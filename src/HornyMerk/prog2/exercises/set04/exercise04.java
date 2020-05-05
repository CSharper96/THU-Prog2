package HornyMerk.prog2.exercises.set04;

import HornyMerk.prog2.exercises.set04.General.Car;
import HornyMerk.prog2.exercises.set04.General.Locomotive;
import HornyMerk.prog2.exercises.set04.General.Train;

public class exercise04
{
    public static void main(String[] args)
    {
        Train train = new Train(new Locomotive(5311, 23));
        train.Add(0, new Car(50, 12));
        train.Add(1, new Car(75, 15));
        train.Add(2, new Car(100, 20));

        Train newTrain = new Train(new Locomotive(5409, 21));
        newTrain.Add(0, new Car(60,13));
        newTrain.Add(1, new Car(80,18));

        newTrain.Relink(train); //Gad NED!
    }
}
