package ch.diso.lambda;

import ch.diso.exercise.lambda.exercise1.Color;
import ch.diso.exercise.lambda.exercise1.Shape;
import ch.diso.exercise.lambda.exercise1.Shapes;
import ch.diso.lambda.util.FeatureMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Exercise 1 - Internal vs External iteration.
 * <p>
 * As described in Brian Goetz's State of the Lambda - Libraries Edition[0], Java's collection classes provide a way for
 * clients to enumerate the members of a collection. Currently, this is iteration is "External" - that is, the
 * collection can be iterated in sequence, by the client code.
 * </p>
 * <p>
 * This refers to the trusty "for loop":
 * TODO Bug in the Javdoc processor? It claims the code annotation construct is invalid
 * <pre>
 * {@code
 *    for (Shape s: shapes) {
 *       s.setColor(RED)
 *    }
 * }
 * </pre>
 * </p>
 * <p>
 * JDK 8, with lambdas and an updated Collections library, will allow "Internal" iteration. In this case, the collection
 * receives some code, and decides how to apply that to its elements. This has several benefits, including:
 * - allowing the collection to decide how to handle executing given code, including opening the door to parallelism and laziness
 * - leads to a style where operations can be pipelined, into a more fluent, readable style.
 * </p>
 * <p>
 * Internal iteration, using lambda expression syntax, turns the above for loop into:
 * <pre>
 * {@code
 * shapes.forEach(s -> s.setColor(RED))
 * }
 * </pre>
 * Where <code>s -> s.setColor(RED)</code> is a lambda expression, which is passed into forEach, and invoked inside forEach. Lambda
 * expressions have a type, called a "Functional Interface". In this case the lambda is of type Consumer. Consumer declares
 * a single method, <code>void accept(T t)</code>. This is all hidden by the Java compiler, and unless you extract the lambda
 * to a variable, or write a method which accepts a lambda, you don't really need to know about it.
 * </p>
 * <p>
 * The tests below can be made to pass using for loops. Try to make them pass without using a for loop.
 * </p>
 *
 * @see java.lang.Iterable#forEach
 * @see Shape
 * @see Shapes
 * @see Color
 */
public class ShapesTest {

    @Test
    public void changeColorOfAllShapes() {
        List<Shape> myShapes = Arrays.asList(
                new Shape(Color.BLUE),
                new Shape(Color.BLACK),
                new Shape(Color.YELLOW));

        // method under test
        Shapes.colorAll(myShapes, Color.RED);

        assertThat(myShapes, hasSize(3));
        assertThat(myShapes, everyItem(hasColor(Color.RED)));
    }

    @Test
    public void buildStringRepresentingAllShapes() {
        List<Shape> allMyShapes = Arrays.asList(
                new Shape(Color.RED),
                new Shape(Color.BLACK),
                new Shape(Color.YELLOW));
        StringBuilder builder = new StringBuilder();

        // method under test
        Shapes.makeStringOfAllColors(allMyShapes, builder);

        assertThat(builder.toString(), equalTo("[a RED shape][a BLACK shape][a YELLOW shape]"));
    }

    @Test
    public void changeColorOfAllShapes_AND_buildStringShowingAllTheOldColors() {
        List<Shape> myShapes = Arrays.asList(
                new Shape(Color.BLUE),
                new Shape(Color.BLACK),
                new Shape(Color.YELLOW));
        StringBuilder builder = new StringBuilder();

        Shapes.changeColorAndMakeStringOfOldColors(myShapes, Color.RED, builder);

        assertThat(myShapes, hasSize(3));
        assertThat(myShapes, everyItem(hasColor(Color.RED)));
        assertThat(builder.toString(), equalTo("[a BLUE shape][a BLACK shape][a YELLOW shape]"));
    }

    // ----- Test helpers -----

    private static Matcher<Shape> hasColor(Color color) {
        return FeatureMatchers.from(Matchers.is(color), "has color", "color", Shape::getColor);
    }

}