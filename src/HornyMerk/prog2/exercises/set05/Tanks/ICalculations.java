package HornyMerk.prog2.exercises.set05.Tanks;

public interface ICalculations {
    default void calculateVolume(Tank tank)
    {
        if(tank.isCubic)
            cubicVolume(tank);
        else if(tank.isCylindrical)
            cylindricalVolume(tank);
        else if(tank.isSpherical)
            sphericalVolume(tank);
        else System.out.println("Gad ned!");
    }

    private void cubicVolume(Tank tank)
    {
        tank.Volume = tank.Length * tank.Width * tank.Height;
        tank.Volume = (Math.round(100.0 * tank.Volume) / 100.0);
    }

    private void sphericalVolume(Tank tank)
    {
        tank.Volume = (4.0 / 3.0) * Math.PI * Math.pow(tank.Radius, 3);
        tank.Volume = (Math.round(100.0 * tank.Volume) / 100.0);
    }

    private void cylindricalVolume(Tank tank)
    {
        tank.Volume = Math.PI * Math.pow(tank.Radius, 2) * tank.Height;
        tank.Volume = (Math.round(100.0 * tank.Volume) / 100.0);
    }

    default void calculateSurface(Tank tank)
    {
        if(tank.isCubic)
            cubicSurface(tank);
        else if(tank.isCylindrical)
            cylindricalSurface(tank);
        else if(tank.isSpherical)
            sphericalSurface(tank);
        else System.out.println("Gad ned!");
    }

    private void cubicSurface(Tank tank)
    {
        tank.Surface = 2 * (tank.Length * tank.Width + tank.Length * tank.Height + tank.Width * tank.Height);
        tank.Surface = (Math.round(100.0 * tank.Surface) / 100.0);
    }

    private void sphericalSurface(Tank tank)
    {
        tank.Surface = 4 * Math.PI * Math.pow(tank.Radius, 2);
        tank.Surface = (Math.round(100.0 * tank.Surface) / 100.0);
    }

    private void cylindricalSurface(Tank tank)
    {
        tank.Surface = 2 * Math.PI * tank.Radius * (tank.Radius + tank.Height);
        tank.Surface = (Math.round(100.0 * tank.Surface) / 100.0);
    }
}
