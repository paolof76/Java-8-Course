import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comarison {

    private static List<Person> list;

    public static void main(String[] args) {

        // Java 7
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int n = p1.getLastName().compareTo(p2.getLastName());
                if (n == 0) {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
                return n;
            }
        });

        // Java 8
        list.sort(Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName));
    }

    public static class Person {

        String firstName;
        String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

}
