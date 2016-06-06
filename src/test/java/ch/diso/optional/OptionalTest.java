package ch.diso.optional;

import ch.diso.exercises.optional.OptionalExercise;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OptionalTest {

    @Test
    public void testSum() {

        Integer a = null;
        Integer b = 2;

        OptionalExercise test = new OptionalExercise();
        Integer result = test.sum(a, b);

        assertThat(result, equalTo(2));

    }
}
