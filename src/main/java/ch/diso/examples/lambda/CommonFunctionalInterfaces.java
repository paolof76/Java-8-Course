package ch.diso.examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CommonFunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> list = map(
                Arrays.asList("Mein", "Name", "ist", "Daniel", "Senften"),
                (String s) -> s.length());

        // [4, 4, 3, 6, 7]
        System.out.println(list);


        // Composing Functions
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;

        Function<Integer, Integer> h = f.compose(g);

        // 5
        System.out.println(h.apply(2));

    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            result.add(f.apply(s));
        }
        return result;
    }
}
