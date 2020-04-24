package HornyMerk.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Naturals extends Sequence
{
    public ArrayList<Integer> Numbers;
    static int counter;
    public Naturals()
    {
        Numbers = new ArrayList<Integer>();
        InitNumbers();
        counter = 0;
    }
    private void InitNumbers()
    {
        for(int i = 1; i <= 50; i++)
            Numbers.add(i);
    }
    public boolean hasNext()
    {
        if(hasNext(counter, this.Numbers)) return true;
        else return false;
    }
    public int nextElement() throws Exception
    {
        if(hasNext())
        {
            counter ++;
            return nextElement(counter, this.Numbers);
        }
        else throw new Exception("No next Element!");
    }
    public int GetElement()
    {
        return Numbers.get(counter);
    }
}
