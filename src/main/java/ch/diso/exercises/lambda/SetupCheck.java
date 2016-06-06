package ch.diso.exercises.lambda;

import java.util.List;

import static java.util.Arrays.asList;

public class SetupCheck {

    /**
     * Utility method to warn users if they have an incorrect environment
     *
     * @param args - should be <code>null</code>
     */
    public static void main(String... args) {
        List<String> messages = asList(
                "If this source file does not compile, you have not configured your development setup correctly.",
                "It uses both a new JDK 8 syntax (method references with '::') and a new JDK 8 library method (Iterable#forEach)",
                "You should also be able to execute this main method, and see this message printed to the console.",
                "",
                "Until this source file compiles, you will be unable to make progress in the tutorial.");

        messages.forEach(System.out::println);
    }

}
