package HornyMerk.prog2.exercises.set04.General;

import java.util.ArrayList;
import java.util.List;

public class Locomotive extends Car
{
    private Car _FirstCar;
    public int Type;
    public int Length;

    public Locomotive(int type, int length)
    {
        _FirstCar = null;
        Type = type;
        Length = length;
    }

    public void SetFirstCar(Car firstCar)
    {
        _FirstCar = firstCar;
    }
    public Car GetFirstCar()
    {
        return _FirstCar;
    }
    public boolean HasCars()
    {
        if(_FirstCar != null) return true;
        else return false;
    }
    public void Add(int index, Car newCar)
    {
        if(index < 0) System.out.println("Gad ned!");
        else if (index == 0) _FirstCar = newCar;
        else
        {
            Car nextCar = _FirstCar;
            for(int i = 1; i < index; i++)
            {
                if(nextCar.HasNextCar())
                    nextCar = nextCar.GetNextCar();
                else
                {
                    System.out.println("Gad ned zum 2.");
                    return;
                }
            }
            nextCar.SetNextCar(newCar);
        }
    }
    public int GetPassengers()
    {
        Car actualCar = _FirstCar;
        int passengers = 0;

        if(actualCar == null) return passengers;

        while(actualCar.HasNextCar())
        {
            passengers += actualCar.Passengers;
            actualCar = actualCar.GetNextCar();
        }
        passengers += actualCar.Passengers;
        return passengers;
    }
    public int GetLength()
    {
        Car actualCar = _FirstCar;
        int length = this.Length;

        if(actualCar == null) return length;

        while(actualCar.HasNextCar())
        {
            length += actualCar.Length;
            actualCar = actualCar.GetNextCar();
        }
        length += actualCar.Length;
        return length;
    }
    public Car RemoveFirst()
    {
        Car removedCar = null;
        if(this._FirstCar != null)
        {
            removedCar = this._FirstCar;
            if(this._FirstCar.HasNextCar())
            {
                List<Car> cars = new ArrayList<>();
                Car actualCar = _FirstCar.GetNextCar();
                while (actualCar.HasNextCar())
                {
                    cars.add(actualCar);
                    actualCar = actualCar.GetNextCar();
                }
                cars.add(actualCar);

                for(int i = 0; i < cars.size(); i++)
                {
                    Add(i, cars.get(i));
                }
                Add(cars.size(), null);
            }
            else this._FirstCar = null;
        }
        else return removedCar;
        removedCar.SetNextCar(null);
        return removedCar;
    }
    public int GetIndex()
    {
        int index = 0;
        if (_FirstCar != null)
        {
            index++;
            if(_FirstCar.HasNextCar()) {
                index++;
                Car actualCar = _FirstCar.GetNextCar();
                while (actualCar.HasNextCar())
                {
                    actualCar = actualCar.GetNextCar();
                    index++;
                }
            }
        }
        return index;
    }
}
