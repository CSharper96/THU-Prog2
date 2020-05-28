package HornyMerk.prog2.exercises.set07.Utilities;


public class Deque<T>
{
    private Object[] _Array;
    private int _Size;
    private int _StartIndex;
    private int _EndIndex;

    public Deque(T[] array)
    {
        _Array = array;
        _Size = array.length;
        _StartIndex = 0;
        _EndIndex = 1;
    }
    public boolean isEmpty()
    {
        return true;
    }
    public boolean isFull()
    {
        return true;
    }
    public int size()
    {
        return _Size;
    }
    public int capacity()
    {
        return 0;
    }
    public T get(int i)
    {
        return (T) _Array[i];
    }
    public void addFirst(T elem)
    {
        _Array[0] = elem;
        _EndIndex++;
    }
    public T getFirst()
    {
        return (T) _Array[0];
    }
    public T removeFirst()
    {
        Object temp = _Array[0];
        _Array[0] = null;
        _EndIndex--;
        return (T) temp;
    }
    public void addLast(T elem)
    {
        _Array[_EndIndex] = elem;
        _EndIndex++;
    }
    public T gerLast()
    {
        return (T) _Array[_EndIndex];
    }
    public T removeLast()
    {
        Object temp = _Array[0];
        _Array[_EndIndex] = null;
        _EndIndex--;
        return (T) temp;
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i < _Size; i++)
            str += _Array[i] + " ";
        return str;
    }
}
