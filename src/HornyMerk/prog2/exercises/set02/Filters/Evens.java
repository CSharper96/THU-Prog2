package HornyMerk.prog2.exercises.set02.Filters;

import HornyMerk.prog2.exercises.set02.sequences.Naturals;
import HornyMerk.prog2.exercises.set02.sequences.Range;

import java.util.ArrayList;

public class Evens
{
    public ArrayList<Integer> EvenNumbers;
    public Evens(Naturals naturals)
    {
        EvenNumbers = new ArrayList<>();
        GenerateEvenNumbers((ArrayList<Integer>) naturals.Numbers);
    }
    public Evens(Range range)
    {
        EvenNumbers = new ArrayList<>();
        GenerateEvenNumbers(range.Numbers);
    }
    private void GenerateEvenNumbers(ArrayList<Integer> numbers)
    {
        for(int number : numbers)
        {
            if(testPassCondition(number)) EvenNumbers.add(number);
        }
    }
    private boolean testPassCondition(int element)
    {
        if(element % 2 == 0)
            return true;
        else return false;
    }
}
