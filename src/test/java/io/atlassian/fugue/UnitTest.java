package io.atlassian.fugue;

import org.junit.Test;

import static io.atlassian.fugue.Unit.Unit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UnitTest {
    @Test
    public void unitValueIsNotNull() {
        assertThat(Unit.VALUE, is(not(nullValue())));
    }

    @Test
    public void unitMethodIsSameAsValue() {
        assertThat(Unit(), is(Unit.VALUE));
    }
}