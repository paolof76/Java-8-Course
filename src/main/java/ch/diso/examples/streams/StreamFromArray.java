package ch.diso.examples.streams;

import java.util.Arrays;

public class StreamFromArray {

    public static void main(String[] args) {

        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        // 41
        System.out.print(sum);
    }
}
