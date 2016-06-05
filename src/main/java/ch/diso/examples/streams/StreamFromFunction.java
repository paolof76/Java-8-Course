package ch.diso.examples.streams;

import java.util.stream.Stream;

public class StreamFromFunction {

    public static void main(String[] args) {

        // 0
        // 2
        // 4
        Stream.iterate(0, n -> n + 2)
                .limit(3)
                .forEach(System.out::println);
    }
}
