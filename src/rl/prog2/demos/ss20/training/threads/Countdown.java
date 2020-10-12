package rl.prog2.ss20.training.threads;

public class Countdown extends Thread {

    private boolean isCanceled;

    public void cancel() {
        isCanceled = true;
    }

    @Override
    public void run() {
        for (int i = 10; i >=0 && !isCanceled; i--) {
            if (i == 0)
                System.out.println("Go!");
            else {
                System.out.println(i + "...");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
