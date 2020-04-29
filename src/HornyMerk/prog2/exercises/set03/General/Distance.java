package HornyMerk.prog2.exercises.set03.General;

public class Distance
{
    public Location A;
    public Location B;
    public double Length;

    public Distance()
    {
    }
    public Distance(Location a, Location b)
    {
        A = a;
        B = b;
        Calculate();
    }
    private void Calculate()
    {
        int x = B.X - A.X;
        int y = B.Y - A.Y;
        double sum = (Math.pow(x, 2)) + (Math.pow(y, 2));
        Length = Math.sqrt(sum);
    }
}
