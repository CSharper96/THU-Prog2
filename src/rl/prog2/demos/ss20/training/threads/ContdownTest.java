package rl.prog2.ss20.training.threads;

public class ContdownTest {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        countdown.start();
        // System.out.println("Test");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // countdown.stop(); // Vorsicht!!!!
        countdown.cancel();
        // countdown.start(); // Fehler!!
    }
}
