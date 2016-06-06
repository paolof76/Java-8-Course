package ch.diso.exercises.serialize.test;

import ch.diso.exercises.serialize.domain.Item;
import ch.diso.exercises.serialize.domain.ShoppingCart;

import java.text.NumberFormat;

public class SerializeTest {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart(10);

        cart.addItem(new Item(101, "Whammo Frisbee", 10.95));
        cart.addItem(new Item(123, "Wilson Soccer Pro Soccer ball", 29.95));
        cart.addItem(new Item(45, "Penn Tennis Balls - A set of 4 Cans", 17.49));

        System.out.println("Shopping cart contains " + cart.getCartSize() + " items");
        System.out.println("Shopping cart total: "
                + NumberFormat.getCurrencyInstance().format(cart.getCartTotal()));

        String directory = "/tmp/";
        // Your code goes here....
    }
}