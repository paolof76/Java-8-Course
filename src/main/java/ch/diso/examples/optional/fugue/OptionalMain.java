package ch.diso.examples.optional.fugue;


import io.atlassian.fugue.Option;

public class OptionalMain {

    public static void main(String[] args) {

        // Creating an empty optional
        Person person = null;

        // Unknown
        System.out.println(getCarInsuranceName(person));
    }

    public static String getCarInsuranceName(Person person) {
        return (Option.option(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .getOrElse("Unknown"));
    }

}