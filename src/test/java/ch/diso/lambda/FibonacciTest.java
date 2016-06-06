package ch.diso.lambda;

import org.junit.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.Assert.assertEquals;

/**
 * https://de.wikipedia.org/wiki/Fibonacci-Folge
 */
public class FibonacciTest {

    private IntUnaryOperator fib;

    {
        fib = (n) -> (n < 2) ? n : fib.applyAsInt(n - 1) + fib.applyAsInt(n - 2);
    }

    @Test
    public void test5() {
        assertEquals(5, fib.applyAsInt(5));
    }

    @Test
    public void test6() {
        assertEquals(8, fib.applyAsInt(6));
    }

    @Test
    public void test7() {
        assertEquals(13, fib.applyAsInt(7));
    }

    @Test
    public void test10() {
        assertEquals(55, fib.applyAsInt(10));
    }

    @Test
    public void test20() {
        assertEquals(6_765, fib.applyAsInt(20));
    }

}