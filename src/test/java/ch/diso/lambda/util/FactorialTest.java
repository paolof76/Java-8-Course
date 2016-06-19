package ch.diso.lambda.util;

import org.junit.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * https://de.wikipedia.org/wiki/Fakultät_(Mathematik)
 */
public class FactorialTest {

    private IntUnaryOperator factorial;

    {
        factorial = i -> i == 0 ? 1 : i * factorial.applyAsInt(i - 1);
    }

    @Test
    public void test5() {
        assertEquals(120, factorial.applyAsInt(5));
    }

}
