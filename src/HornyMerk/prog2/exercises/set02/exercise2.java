package HornyMerk.prog2.exercises.set02;

import HornyMerk.prog2.exercises.set02.Filters.Evens;
import HornyMerk.prog2.exercises.set02.Filters.ZapMultiples;
import HornyMerk.prog2.exercises.set02.sequences.Naturals;
import HornyMerk.prog2.exercises.set02.sequences.PrimeNumbers;
import HornyMerk.prog2.exercises.set02.sequences.Range;

import static HornyMerk.prog2.exercises.set02.SequenceTest.println;

public class exercise2
{
    public static void main(String[] args)
    {
        //Test by Alex
        SequenceTest.println(new Naturals());
        SequenceTest.println(new Range(7, 14));
        SequenceTest.println(new Evens(new Range(7, 14)));
        SequenceTest.println(new ZapMultiples(new Range(7, 14), 3));
        SequenceTest.println(new PrimeNumbers());
    }
}
