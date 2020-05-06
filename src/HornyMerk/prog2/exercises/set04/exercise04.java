package HornyMerk.prog2.exercises.set04;

import HornyMerk.prog2.exercises.set04.General.Car;
import HornyMerk.prog2.exercises.set04.General.Locomotive;
import HornyMerk.prog2.exercises.set04.General.Train;
import HornyMerk.prog2.exercises.set04.UtililityTest.TestingClass;

public class exercise04
{
    public static void main(String[] args)
    {
        Train santaFe = new Train(new Locomotive(5311, 23));
        santaFe.Add(0, new Car(50, 12));
        santaFe.Add(1, new Car(75, 15));
        santaFe.Add(2, new Car(100, 20));

        Train rioGrandeExpress = new Train(new Locomotive(5409, 21));
        rioGrandeExpress.Add(0, new Car(60,13));
        rioGrandeExpress.Add(1, new Car(80,18));

        rioGrandeExpress.Relink(santaFe);

        rioGrandeExpress.Revert();

        System.out.println(rioGrandeExpress.ToString());
        System.out.println(santaFe.ToString());

        TestingClass testingClass = new TestingClass();
        testingClass.StartUtilityTest();
    }
}
