package ch.diso.examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateFunction {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = filter(
                Arrays.asList("Daniel", "", "Senften"),
                (String s) -> !s.isEmpty());
        System.out.println(list);
    }

}