package ch.diso.examples.optional.fugue;

import io.atlassian.fugue.Option;

public class Person {

    private Car car;

    public Option<Car> getCar() {
        return Option.some(car);
    }
}