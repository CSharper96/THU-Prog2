package HornyMerk.prog2.exercises.set05.Tanks;

public class SphericalTank extends Properties
{
    private Tank NextTank;
    public SphericalTank(double radius)
    {
        this.Radius = radius;
    }
    public void add(Tank nextTank)
    {
        NextTank = nextTank;
    }
    public void calculateSurface()
    {
        calculateSurface(this);
    }
    public void calculateVolume()
    {
        calculateVolume(this);
    }
}
