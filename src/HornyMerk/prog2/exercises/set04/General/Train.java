package HornyMerk.prog2.exercises.set04.General;

import java.util.ArrayList;
import java.util.List;

public class Train
{
    public List<Car> Cars;
    public Locomotive Locomotive;

    public Train(Locomotive locomotive)
    {
        Cars = new ArrayList<>();
        Locomotive = locomotive;
    }

    public boolean HasCars()
    {
        if(Locomotive != null && Cars.size() >= 1)
            return true;
        else return false;
    }
    public void Add(int index, Car car)
    {
        Cars.add(index, car);
    }
    public int GetPassengers()
    {
        int passengers = 0;
        for(Car car : Cars)
            passengers += car.Passengers;
        return passengers;
    }
    public int GetLength()
    {
        int length = 0;
        length += Locomotive.Length;
        for(Car car : Cars)
            length += car.Length;
        return length;
    }
    public Car RemoveFirst()
    {
        if(Cars == null || Cars.size() == 0) return null;
        Car firstCar = Cars.get(0);
        Cars.remove(firstCar);
        return firstCar;
    }
    public void Relink(Train train)
    {
        //Todo!
    }
    public void Revert()
    {
        //Todo!
    }
    public String ToString()
    {
        return "Train has the locomotive " + Locomotive.Type +
                ", with the total length of " + GetLength() +
                ", a capacity of " + GetPassengers() +
                " passengers and a total number of " + this.Cars.size() + " cars!";
    }
}
