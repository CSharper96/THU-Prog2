package HornyMerk.prog2.exercises.set04.General;

public class Car
{
    private Car _NextCar;
    public int Passengers;
    public int Length;

    public Car(int passengers, int length)
    {
        _NextCar = null;
        Passengers = passengers;
        Length = length;
    }
    public Car()
    {
        _NextCar = null;
    }

    public void SetNextCar(Car nextCar)
    {
        _NextCar = nextCar;
    }
    public Car GetNextCar()
    {
        return _NextCar;
    }
    public boolean HasNextCar()
    {
        if(_NextCar != null) return true;
        else return false;
    }
}
