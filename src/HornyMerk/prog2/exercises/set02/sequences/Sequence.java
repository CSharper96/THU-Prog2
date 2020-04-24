package HornyMerk.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Sequence
{
    protected boolean hasNext(int pos, ArrayList<Integer> numbers)
    {
        try
        {
            if(numbers.get(pos + 1) != null)
                return true;
        }
        catch (Exception e)
        {
            return false;
        }
        return false;
    }
    protected int nextElement(int pos, ArrayList<Integer> numbers)
    {
        return numbers.get(pos);
    }
}
