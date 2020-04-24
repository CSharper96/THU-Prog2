package HornyMerk.prog2.exercises.set02.sequences;

import java.util.ArrayList;
import java.util.List;

public class Naturals extends Sequence
{
    public List<Integer> Numbers;
    static int _Counter;
    public Naturals()
    {
        Numbers = new ArrayList<Integer>();
        InitNumbers();
        _Counter = 0;
    }
    private void InitNumbers()
    {
        for(int i = 1; i <= 50; i++)
            Numbers.add(i);
    }
    public boolean hasNext()
    {
        if(hasNext(_Counter, (ArrayList<Integer>) Numbers)) return true;
        else return false;
    }
    public int nextElement() throws Exception
    {
        if(hasNext())
        {
            _Counter ++;
            return nextElement(_Counter, (ArrayList<Integer>) Numbers);
        }
        else throw new Exception("No next Element!");
    }
    public int GetElement()
    {
        return Numbers.get(_Counter);
    }
}
