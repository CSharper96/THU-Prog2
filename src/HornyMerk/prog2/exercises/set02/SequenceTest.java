package HornyMerk.prog2.exercises.set02;

import HornyMerk.prog2.exercises.set02.sequences.Naturals;
import HornyMerk.prog2.exercises.set02.sequences.Range;

public class SequenceTest
{
    public static void println(Naturals naturals)
    {
        System.out.println(naturals.GetElement());
        while(naturals.hasNext())
        {
            if(naturals.GetElement() >= 10) break;
            try
            {
                System.out.println(naturals.nextElement());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void println(Range range)
    {

    }
}
