package ch.diso.examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {

        Supplier<Apple> c1 = Apple::new; // Supplier<Apple> c1 = () -> new Apple()
        Apple a1 = c1.get();

        // Apple{color='', weight=0}
        System.out.println(a1);


        Function<Integer, Apple> c2 =
                Apple::new; // Function<Integer, Apple> c2 = (weight) -> new Apple(weight);
        Apple a2 = c2.apply(110);

        // Apple{color='', weight=110}
        System.out.println(a2);


        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);

        // [Apple{color='', weight=7}, Apple{color='', weight=3}, Apple{color='', weight=4}, Apple{color='', weight=10}]
        System.out.println(apples);
    }

    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    /**
     * A local class representing an apple.
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple() {
        }

        public Apple(int weight) {
            this(weight, "");
        }

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

}
