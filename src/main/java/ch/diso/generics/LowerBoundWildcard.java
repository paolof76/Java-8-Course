package ch.diso.generics;

import java.util.Arrays;
import java.util.List;

public class LowerBoundWildcard {

    /**
     * The lower bounded wildcard restricts the unknown type to be a
     * specific type (<code>Integer</code>) or a super type of that type.
     */
    public static void addNumbers(List<? super Integer> list) {
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        List<Long> longList = Arrays.asList(1L, 2L, 3L);
        List<Integer> integerList = Arrays.asList(1, 2, 3);

        // addNumbers(longList); // Compile error

        addNumbers(integerList);
    }
}
