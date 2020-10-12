package rl.prog2.ss20.training.threads;

public class LockDemo {

    private static Object lock1 = new Object();

    public void doIt() {
        synchronized (lock1) {
            System.out.println("started...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finished...");
        }
    }


    public static void main(String[] args) {
        LockDemo d1 = new LockDemo();
        LockDemo d2 = new LockDemo();
        new Thread(() -> d1.doIt()).start();
        new Thread(() -> d2.doIt()).start();

    }
}
