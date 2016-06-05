package ch.diso.examples.optional;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {

        // Creating an empty optional
        Optional<Person> person = Optional.empty();

        // Unknown
        System.out.println(getCarInsuranceName(person));
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

}