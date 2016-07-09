package ch.diso.examples.optional.fugue;

import io.atlassian.fugue.Option;

public class Car {

    private Insurance insurance;

    public Option<Insurance> getInsurance() {
        return Option.some(insurance);
    }
}