package ch.diso.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import static java.util.Optional.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    private final Optional<Integer> none = empty();

    @Test(expected = NoSuchElementException.class)
    public void getOnNoneThrowsException() {
        none.get();
    }

    @Test
    public void isSet() {
        assertThat(none.isPresent(), is(false));
    }

    @Test
    public void getOrElse() {
        assertThat(none.orElse(1), is(1));
    }

    @Test
    public void map() {
        final Function<Integer, Integer> function = input -> {
            throw new AssertionError("None.map should not call the function.");
        };

        assertThat(none.map(function).isPresent(), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void nullFunctionForMap() {
        none.map(null);
    }

    @Test(expected = NullPointerException.class)
    public void nullPredicateForFilter() {
        none.filter(null);
    }

    @Test
    public void filterTrueReturnsEmpty() {
        assertThat(none.filter(x -> true).isPresent(), is(false));
    }

    @Test
    public void filterFalseReturnsEmpty() {
        assertThat(none.filter(x -> false).isPresent(), is(false));
    }

    @Test
    public void superTypesPermittedOnFilter() {
        final Optional<ArrayList<?>> opt = empty();
        final Optional<ArrayList<?>> nopt = opt.filter(x -> true);
        assertThat(nopt, sameInstance(opt));
    }

    @Test
    public void superTypesPermittedOnMap() {
        final Optional<ArrayList<?>> opt = empty();
        final Optional<Set<?>> size = opt.map(list -> {
            throw new AssertionError("This internal method should never get called.");
        });
        assertThat(size.isPresent(), is(false));
    }

    @Test
    public void hashDoesNotThrowException() {
        none.hashCode();
    }

}