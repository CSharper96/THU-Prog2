package HornyMerk.prog2.exercises.set05.Tanks;

import java.util.ArrayList;

public interface IUtilities
{
    default void add(Tank actualTank, Tank newTank)
    {
        if(!actualTank.hasNext())
        {
            actualTank.NextTank = newTank;
            actualTank.NextTank.PrevTank = actualTank;
        }
        else if(!actualTank.NextTank.hasNext())
        {
            Tank prevTank = actualTank.NextTank;
            Tank nextTank = actualTank.NextTank;
            nextTank.NextTank = newTank;
            newTank.PrevTank = prevTank;
        }
        else
        {
            Tank nextTank = actualTank.NextTank;
            while(nextTank.hasNext())
            {
                nextTank = nextTank.NextTank;
            }
            nextTank.NextTank = newTank;
            nextTank.NextTank.PrevTank = nextTank;
        }
    }

    default ArrayList<Tank> getAllTanks(Tank actualTank, ArrayList<Tank> list)
    {
        generateArrayList(actualTank, list);
        return list;
    }
    private void generateArrayList(Tank actualTank, ArrayList<Tank> list)
    {
        if(actualTank.hasNext())
        {
            list.add(actualTank);
            generateArrayList(actualTank.NextTank, list);
        }
        else
        {
            list.add(actualTank);
            return;
        }
    }
    default String toStringAll(Tank actualTank)
    {
        double totalVolume = 0;
        double totalSurface = 0;
        String str = "All Tanks!\n|\n|\nV\n\n";
        ArrayList<Tank> tanks = actualTank.getAllTanks();
        for(Tank tank : tanks)
        {
            str += tank.toString() + "\n";
            totalVolume += tank.Volume;
            totalSurface += tank.Surface;
        }
        totalVolume = (Math.round(100.0 * totalVolume) / 100.0);
        totalSurface = (Math.round(100.0 * totalSurface) / 100.0);
        str += "\n\nThe total volume is: " + totalVolume + " and the total surface is: " + totalSurface;
        return str;
    }
    default Tank clone(Tank actualTank)
    {
        return actualTank;
    }
    default void delete(int index, Tank actualTank)
    {
        if(index == 0) actualTank = null;
        else if (index > 0 && !actualTank.hasNext()) System.out.println("ERROR!");
        else
        {
            Tank prevTank = null;
            int i = 0;
            while(actualTank.hasNext())
            {
                if(i == index)
                {
                    prevTank.NextTank = actualTank.NextTank;
                    return;
                }
                else
                {
                    actualTank = actualTank.NextTank;
                    prevTank = actualTank.PrevTank;
                    i++;
                }
            }
        }
    }
}