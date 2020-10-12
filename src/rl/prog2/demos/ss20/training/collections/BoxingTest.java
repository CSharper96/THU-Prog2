package rl.prog2.ss20.training.collections;

import java.util.ArrayList;

public class BoxingTest {
    public static void main(String[] args) {
        Integer io = new Integer(42);
        io = 42;
        int i = io.intValue();
        i = io;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(new Integer(42));
        arr.add(42);

        i = arr.get(0).intValue();
        i = arr.get(0);

        double d = arr.get(0).doubleValue();
        d = arr.get(0);

        ArrayList<Double> dArr = new ArrayList<>();
        // dArr.add(42); Error!
        dArr.add(42.0);



    }
}
