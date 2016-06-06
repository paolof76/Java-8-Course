package ch.diso.exercises.concurrent.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class NetworkClientMain {

    public static void main(String[] args) {

        ExecutorService es = Executors.newCachedThreadPool();
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();

        String host = "localhost";

        // Erstellen einiger Aufrufer
        for (int port = 10_000; port < 10_010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            NetworkClientCallable callable = new NetworkClientCallable(lookup);
            Future<RequestResponse> future = es.submit(callable);
            callables.put(lookup, future);
        }

        es.shutdown(); // Es werden keine weiteren Callables mehr akzeptiert

        try {
            // Wir geben den Callables die Möglichkeit abzuschliessen
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            System.out.println("Stopped waiting early");
        }

        // Abholen aud ausgeben vom Kommunikationsresultat
        for (RequestResponse lookup : callables.keySet()) {
            Future<RequestResponse> future = callables.get(lookup);
            try {
                lookup = future.get();
                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
            } catch (ExecutionException | InterruptedException ex) {
                System.out.println("Error talking to " + lookup.host + ":" + lookup.port);
            }
        }
    }
}