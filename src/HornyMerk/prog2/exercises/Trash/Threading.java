package HornyMerk.prog2.exercises.Trash;

import HornyMerk.prog2.exercises.set03.General.Distance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Threading
{
    public static void main(String[] args) throws InterruptedException {
        Runnable test = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(i < 100)
                {
                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        };
        Thread innerRunnable = new Thread(test);
        innerRunnable.setDaemon(true);
        innerRunnable.start();
        Thread countdown = new Thread(new CountdownRunnable());
        countdown.start();
        CountdownThread countdown2 = new CountdownThread();
        countdown2.start();
        Thread.sleep(5000);
        countdown2.cancel();

    }
}
