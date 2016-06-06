package ch.diso.lambda;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class ThreadLocalTest {

    @Test
    public void threadLocalLegacy() {
        AtomicInteger counter = new AtomicInteger(0);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return counter.incrementAndGet();
            }
        };
        assertEquals(threadLocal.get(), (Integer) 1);
        assertEquals(threadLocal.get(), (Integer) 1);
    }

    @Test
    public void threadLocalLambda() {
        AtomicInteger counter = new AtomicInteger(0);
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> counter.incrementAndGet());
        assertEquals(threadLocal.get(), (Integer) 1);
        assertEquals(threadLocal.get(), (Integer) 1);
    }

    @Test
    public void threadLocalMethodReference() {
        AtomicInteger counter = new AtomicInteger(0);
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(counter::incrementAndGet);
        assertEquals(threadLocal.get(), (Integer) 1);
        assertEquals(threadLocal.get(), (Integer) 1);
    }

}