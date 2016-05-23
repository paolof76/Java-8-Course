package ch.diso.lambda.exercise1;

/**
 * A simple shape, whose only attribute is a Color, which can be changed.
 */
@SuppressWarnings("ALL")
public class Shape {

    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("[a %s shape]", color.name());
    }
}
