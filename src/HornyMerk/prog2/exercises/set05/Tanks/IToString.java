package HornyMerk.prog2.exercises.set05.Tanks;

public interface IToString
{
    default String cubicString(Tank tank)
    {
        String str = "";
        str += "Type: Cubic\n";
        str += "Length: " + tank.Length + "\n";
        str += "Width: " + tank.Width + "\n";
        str += "Height: " + tank.Height + "\n";
        str += "Volume: " + tank.Volume + "\n";
        str += "Surface: " + tank.Surface + "\n";
        return str;
    }
    default String cylinderString(Tank tank)
    {
        String str = "";
        str += "Type: Cylindrical\n";
        str += "Radius: " + tank.Radius + "\n";
        str += "Height: " + tank.Height + "\n";
        str += "Volume: " + tank.Volume + "\n";
        str += "Surface: " + tank.Surface + "\n";
        return str;
    }
    default String sphereString(Tank tank)
    {
        String str = "";
        str += "Type: Spherical\n";
        str += "Radius: " + tank.Radius + "\n";
        str += "Volume: " + tank.Volume + "\n";
        str += "Surface: " + tank.Surface + "\n";
        return str;
    }
}
