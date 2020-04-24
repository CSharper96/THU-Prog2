package HornyMerk.prog2.exercises.set02;

import HornyMerk.prog2.exercises.set02.Filters.Evens;
import HornyMerk.prog2.exercises.set02.Filters.ZapMultiples;
import HornyMerk.prog2.exercises.set02.sequences.Naturals;
import HornyMerk.prog2.exercises.set02.sequences.Range;

public class SequenceTest
{
    public static void println(Naturals naturals)
    {
        System.out.println("\nNaturals from 1 to 10:\n");
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
        System.out.println("\n\nRange from 7 to 14:\n");
        System.out.println(range.GetElement());
        while(range.hasNext())
        {
            try
            {
                System.out.println(range.nextElement());
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void println(Evens evens)
    {
        System.out.println("\n\nEven numbers:\n");
        for(int number : evens.EvenNumbers)
            System.out.println(number);
    }
    public static void println(ZapMultiples zapMultiples)
    {
        System.out.println("\n\nMultiple numbers:\n");
        for(int number : zapMultiples.MultipleNumbers)
            System.out.println(number);
    }
}
