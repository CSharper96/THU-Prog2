package HornyMerk.prog2.exercises.set05;

import HornyMerk.prog2.exercises.set05.Tanks.Tank;

import java.util.ArrayList;

public class exercise05
{
    public static void main(String[] args)
    {
        Tank cubic = new Tank(5, 4, 3);
        Tank cylin = new Tank(5, 4);
        Tank spher = new Tank(5);
        cubic.add(cylin);
        cubic.add(spher);
        cubic.add(new Tank(1));
        cubic.add(new Tank(2));
        cubic.add(new Tank(3));
        cubic.add(new Tank(4));
        Tank newTank = cubic.clone();
        cubic.delete(4);
        ArrayList<Tank> list = cubic.getAllTanks();
        System.out.println(cubic.toString());
        System.out.println(cubic.toStringAll());
    }
}
