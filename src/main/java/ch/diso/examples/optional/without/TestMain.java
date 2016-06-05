package ch.diso.examples.optional.without;

public class TestMain {

    public static void main(String[] args) {

        Person person = new Person();

        // Exception in thread "main" java.lang.NullPointerException
        System.out.println(getCarInsuranceName(person));
    }

    private static String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }
}
