package ch.diso.examples.streams;

import java.util.Arrays;
import java.util.List;

public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        {
            // sum it up the old way
            int sum = 0;
            for (int x : numbers) {
                sum += x;
            }
            // 10
            System.out.println(sum);
        }

        {
            int sum = numbers.stream().reduce(0, (a, b) -> a + b);
            // 10
            System.out.println(sum);
        }
    }
}