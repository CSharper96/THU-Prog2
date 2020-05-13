package HornyMerk.prog2.exercises.set05;

import HornyMerk.prog2.exercises.set05.Tanks.CuboidTank;
import HornyMerk.prog2.exercises.set05.Tanks.CylindricalTank;
import HornyMerk.prog2.exercises.set05.Tanks.SphericalTank;
import HornyMerk.prog2.exercises.set05.Tanks.Tank;

public class exercise05
{
    public static void main(String[] args)
    {
        CylindricalTank tank = new CylindricalTank(3, 3);
        tank.add(new Tank(new SphericalTank(5)));
        CylindricalTank tank2 = tank.clone();
    }
}
