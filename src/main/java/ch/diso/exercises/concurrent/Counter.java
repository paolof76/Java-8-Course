package ch.diso.exercises.concurrent;

public class Counter implements Runnable {

    @Override
    public void run() {
        int x = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("The current value of x is: " + x++);
            try {
                Thread.sleep(1_000); // Millisekunden
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}