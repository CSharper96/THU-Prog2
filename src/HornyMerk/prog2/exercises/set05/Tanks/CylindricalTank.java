package HornyMerk.prog2.exercises.set05.Tanks;

public class CylindricalTank extends Properties
{
    private Tank NextTank;
    public CylindricalTank(double height, double radius)
    {
        this.Height = height;
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
    public CylindricalTank clone()
    {
        return this;
    }
}
