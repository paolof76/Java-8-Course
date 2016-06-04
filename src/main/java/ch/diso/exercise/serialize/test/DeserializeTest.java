package ch.diso.exercise.serialize.test;

import ch.diso.exercise.serialize.domain.ShoppingCart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeserializeTest {

    public static void main(String[] args) {
        ShoppingCart cart = null;
        String custID = null;
        System.out.println("Enter the ID of the cart file to deserialize or q exit.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            custID = in.readLine();
            if (custID.equals("q")) {
                System.exit(0);
            }
        } catch (IOException e) { // Catch any IO exceptions.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }

        String directory = "/tmp/";
        String cartFile = directory + "cart" + custID + ".ser";

        // Your code goes here....
    }
}