package HornyMerk.prog2.exercises.set05.Tanks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class Tank extends Properties implements IToString, IUtilities
{
    public Tank NextTank = null;
    public Tank PrevTank = null;
    protected boolean isCylindrical = false;
    protected boolean isSpherical = false;
    protected boolean isCubic = false;

    public Tank(double length, double width, double height)
    {
        this.Length = length;
        this.Width = width;
        this.Height = height;
        isCubic = true;
    }
    public Tank(double height, double radius)
    {
        this.Height = height;
        this.Radius = radius;
        isCylindrical = true;
    }
    public Tank(double radius)
    {
        this.Radius = radius;
        isSpherical = true;
    }
    public void calculateVolume()
    {
        calculateVolume(this);
    }
    public void calculateSurface()
    {
        calculateSurface(this);
    }
    public boolean hasNext()
    {
        if(NextTank == null) return false;
        else return true;
    }
    public void add(Tank newTank)
    {
        add(this, newTank);
    }
    public String toString()
    {
        if(this.Volume == 0) calculateVolume();
        if(this.Surface == 0) calculateSurface();
        String str = "Tank-Data:\n";
        if (isCubic) {
            str += cubicString(this);
        }
        else if (isCylindrical) {
            str += cylinderString(this);
        }
        else if (isSpherical) {
            str += sphereString(this);
        }
        else str += "Not implemented!!";
        return str;
    }
    public String toStringAll()
    {
        return toStringAll(this);
    }
    public ArrayList<Tank> getAllTanks()
    {
        return getAllTanks(this, new ArrayList<>());
    }
    public void delete(int index)
    {
        delete(index, this);
    }
    public Tank clone()
    {
        return clone(this);
    }
}
