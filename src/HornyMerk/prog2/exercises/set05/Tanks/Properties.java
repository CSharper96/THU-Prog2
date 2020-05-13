package HornyMerk.prog2.exercises.set05.Tanks;

import java.lang.reflect.Type;
import java.util.Collection;

public class Properties
{
    public double Volume;
    public double Surface;
    protected double Length;
    protected double Width;
    protected double Height;
    protected double Radius;

    protected void calculateVolume(CuboidTank tank)
    {
        Volume = Length * Width * Height;
    }
    protected void calculateVolume(SphericalTank tank)
    {
        Volume = (4 / 3) * Math.PI * Math.pow(Radius, 3);
    }
    protected void calculateVolume(CylindricalTank tank)
    {
        Volume = Math.PI * Math.pow(Radius, 2) * Height;
    }
    protected void calculateSurface(CuboidTank tank)
    {
        Surface = 2 * (Length * Width + Length * Height + Width * Height);
    }
    protected void calculateSurface(SphericalTank tank)
    {
        Surface = 4 * Math.PI * Math.pow(Radius, 2);
    }
    protected void calculateSurface(CylindricalTank tank)
    {
        Surface = 2 * Math.PI * Radius * (Radius + Height);
    }
}
