package HornyMerk.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Range extends Sequence
{
    public ArrayList<Integer> Numbers;
    private int _Lower;
    private int _Upper;
    static int _Counter;
    public Range(int lower, int upper)
    {
        Numbers = new ArrayList<>();
        _Lower = lower;
        _Upper = upper;
        _Counter = 0;
        InitRange();
    }
    private void InitRange()
    {
        for(int i = _Lower; i <= _Upper; i++)
            Numbers.add(i);
    }
    public boolean hasNext()
    {
        if(hasNext(_Counter, this.Numbers)) return true;
        else return false;
    }
    public int nextElement() throws Exception
    {
        if(hasNext())
        {
            _Counter ++;
            return nextElement(_Counter, this.Numbers);
        }
        else throw new Exception("No next Element!");
    }
    public int GetElement()
    {
        return Numbers.get(_Counter);
    }
}
