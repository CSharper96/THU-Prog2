package HornyMerk.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Naturals extends Sequence
{
    public ArrayList<Integer> Numbers;
    static int _Counter;
    public Naturals()
    {
        Numbers = new ArrayList<>();
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
