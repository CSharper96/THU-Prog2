package HornyMerk.prog2.exercises.set05.Tanks;

public class CuboidTank extends Properties
{
    private Tank NextTank;
    public CuboidTank(double length, double width, double height)
    {
        this.Length = length;
        this.Width = width;
        this.Height = height;
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
