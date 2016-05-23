package ch.diso.lambda.exercise1;

import ch.diso.lambda.FeatureMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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