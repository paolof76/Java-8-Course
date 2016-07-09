package io.atlassian.fugue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static io.atlassian.fugue.Iterators.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IteratorsTest {

    @Test(expected = IllegalStateException.class)
    public void removeAfterPeeking() throws Exception {
        final Iterators.Peeking<Integer> integerPeekingIterator = peekingIterator(asList(1, 2).iterator());
        assertThat(integerPeekingIterator.peek(), is(1));
        integerPeekingIterator.remove();
    }

    @Test
    public void peekAfterRemoving() throws Exception {
        final List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        final Iterators.Peeking<Integer> integerPeekingIterator = peekingIterator(testList.listIterator());
        integerPeekingIterator.next();
        integerPeekingIterator.remove();
        assertThat(integerPeekingIterator.peek(), is(2));
    }

    @Test
    public void testSingletonIterator() throws Exception {
        final Iterator<Integer> integerIterator = singletonIterator(1);
        assertThat(integerIterator.hasNext(), is(true));
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.hasNext(), is(false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iteratingTwiceFails() throws Exception {
        final Iterator<Integer> integerIterator = singletonIterator(1);
        assertThat(integerIterator.next(), is(1));
        assertThat(integerIterator.hasNext(), is(false));
        integerIterator.next();
    }

    @Test
    public void testEmptyIterator() throws Exception {
        final Iterator<Integer> intIter = emptyIterator();
        assertThat(intIter.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void unsafeReferenceReuseExternalElementConsumption() {
        final Iterator<Integer> i = asList(1, 2).iterator();
        final Iterators.Peeking<Integer> peeking = peekingIterator(i);
        assertThat(peeking.peek(), is(1));
        assertThat(peeking.next(), is(1));
        assertThat(peeking.hasNext(), is(true));
        assertThat(i.hasNext(), is(true));
        assertThat(i.next(), is(2));
        peeking.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void unsafeReferenceReusePeekConsumesElement() {
        final Iterator<Integer> i = singletonList(1).iterator();
        final Iterators.Peeking<Integer> peeking = peekingIterator(i);
        assertThat(peeking.peek(), is(1));
        i.next();
    }
}