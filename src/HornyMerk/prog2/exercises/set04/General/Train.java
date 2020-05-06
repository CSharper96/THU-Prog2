package HornyMerk.prog2.exercises.set04.General;

import java.util.ArrayList;
import java.util.List;

public class Train extends Locomotive
{
    public Locomotive Locomotive;

    public Train(Locomotive locomotive)
    {
        super(locomotive.Type, locomotive.Length);
        Locomotive = locomotive;
    }
    public void Relink(Locomotive locomotive)
    {
        while (locomotive.HasCars())
        {
            int index = this.GetIndex();
            Car removedCar = locomotive.RemoveFirst();
            this.Add(index, removedCar);
        }
    }
    public void Revert()
    {
        int test = this.GetIndex() - 1;

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < test; i++)
            cars.add(this.RemoveFirst());
        for(int i = cars.size(); i > 0; i--)
            this.Add(this.GetIndex(), cars.get(i - 1));
    }
    public String ToString()
    {
        return ("This train got " + this.GetIndex() +
                " cars, a capacity of " + this.GetPassengers() +
                " passengers and the length of " + this.GetLength() + " m.");
    }
}
