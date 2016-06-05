package ch.diso.examples.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

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
        // [Daniel, Senften]
        System.out.println(list);


        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);

        // before... Method Reference
        inventory.sort((Apple a1, Apple a2)
                -> a1.getWeight().compareTo(a2.getWeight()));

        // ...and after using a Method Reference
        inventory.sort(comparing(Apple::getWeight));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        System.out.println(inventory);


        // Composing Predicates
        Predicate<Apple> redApple = a -> "red".equals(a.getColor());

        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> redAndHeavyApple =
                redApple.and(a -> a.getWeight() > 150);

        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(a -> a.getWeight() > 150)
                        .or(a -> "green".equals(a.getColor()));
    }


    /**
     * A local class representing an apple.
     */
    public static class Apple {
        private int weight = 0;
        private String color = "";

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

    interface ApplePredicate {
        public boolean test(Apple a);
    }

}