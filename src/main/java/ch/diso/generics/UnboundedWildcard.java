package ch.diso.generics;

import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ALL")
public class UnboundedWildcard {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String> stringList = Arrays.asList("one", "two", "three");

        printList(integerList);
        printList(stringList);
    }

    /**
     * The goal of printList is to print a list of any type. To write a
     * generic printList method, use List&lt;?&gt;:
     *
     * @param list
     *     List to be printed
     *
     * @see
     * <a href="https://docs.oracle.com/javase/tutorial/java/generics/unboundedWildcards.html">Java Tutorial</a>
     */
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
