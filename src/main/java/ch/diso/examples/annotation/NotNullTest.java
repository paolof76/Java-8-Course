package ch.diso.examples.annotation;


import org.jetbrains.annotations.NotNull;

public class NotNullTest {

    @NotNull
    private static String name = "Daniel";

    public static void main(String[] args) {
        System.out.println(name);
    }
}
