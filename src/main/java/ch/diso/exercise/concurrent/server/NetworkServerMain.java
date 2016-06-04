package ch.diso.exercise.concurrent.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {

    public static void main(String[] args) {

        // PriceRangeServer Liste erstellen
        List<Runnable> runners = new ArrayList<>();
        for (int port = 10_000; port < 10_010; port++) {
            try {
                runners.add(new PriceRangeServer(port, 20, 110));
            } catch (IOException ex) {
                System.out.println("Port " + port + " already in use");
            }
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Runnable r : runners) {
            executorService.execute(r);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }

        System.out.println("Press enter to quit...");
        try {
            System.in.read();
        } catch (IOException ex) {
        }

        System.out.println("Quiting...");
        executorService.shutdownNow();

    }
}