package ch.diso.streams;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MapVsFlatMap {

    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream

                // [ "a", "b", "hello" ]
                .of("a", "b", "hello")

                .map(String::toUpperCase) // string -> string.toUpperCase()
                .collect(Collectors.toList());
        assertEquals(asList("A", "B", "HELLO"), collected);
    }

    @Test
    public void testflatMap() throws Exception {
        List<Integer> together = Stream

                // [ [1, 2], [3, 4] ]
                .of(asList(1, 2), asList(3, 4))

                // [ 1, 2, 3, 4 ]
                .flatMap(Collection::stream) // numbers -> numbers.stream()
                .map(integer -> integer + 1)
                .collect(Collectors.toList());
        assertEquals(asList(2, 3, 4, 5), together);
    }
}
