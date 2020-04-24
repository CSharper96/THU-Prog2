package HornyMerk.prog2.exercises.set02.Filters;

import HornyMerk.prog2.exercises.set02.sequences.Naturals;
import HornyMerk.prog2.exercises.set02.sequences.Range;

import java.util.ArrayList;

public class ZapMultiples
{
    public ArrayList<Integer> MultipleNumbers;
    private int _Divisor;
    public ZapMultiples(Naturals naturals, int divisor)
    {
        MultipleNumbers = new ArrayList<>();
        _Divisor = divisor;
        GenerateEvenNumbers(naturals.Numbers);
    }
    public ZapMultiples(Range range, int divisor)
    {
        MultipleNumbers = new ArrayList<>();
        _Divisor = divisor;
        GenerateEvenNumbers(range.Numbers);
    }
    private void GenerateEvenNumbers(ArrayList<Integer> numbers)
    {
        for(int number : numbers)
        {
            if(testPassCondition(number)) MultipleNumbers.add(number);
        }
    }
    private boolean testPassCondition(int element)
    {
        if(element % _Divisor == 0)
            return false;
        else return true;
    }
}
