package HornyMerk.prog2.exercises.set07.Utilities;


public class Deque<T>
{
    private Object[] _Array;
    private int _Size;
    private int _Head;
    private int _Tail;

    public Deque(int size)
    {
        _Array = new Object[size];
        _Size = size;
        _Head = 0;
        _Tail = 1;
    }
    public boolean isEmpty()
    {
        boolean condition = false;
        for(int i = 0; i < _Size; i++)
        {
            if (_Array[i] != null) condition = true;
        }
        return condition;
    }
    public boolean isFull()
    {
        boolean condition = true;
        for(int i = 0; i < _Size; i++)
        {
            if (_Array[i] == null) condition = false;
        }
        return condition;
    }
    public int size()
    {
        int size = 0;
        for(int i = 0; i < _Size; i++)
        {
            if(_Array[i] != null) size++;
        }
        return size;
    }
    public int capacity()
    {
        return _Size;
    }
    public T get(int i)
    {
        final T t = (T) _Array[i];
        return t;
    }
    public void addFirst(T elem)
    {
        int size = 0;
        for(int i = 0; i < _Size; i++)
        {
            if(_Array[i] != null) size++;
            else break;
        }

        Object[] tmp = new Object[size + 1];
        tmp[0] = elem;

        for(int i = 1; i < size; i++)
            tmp[i] = _Array[i-1];


        _Array[0] = elem;
        _Tail++;
    }
    public T getFirst()
    {
        final T t = (T) _Array[0];
        return t;
    }
    public T removeFirst()
    {
        Object temp = _Array[0];
        _Array[0] = null;
        _Tail--;
        return (T) temp;
    }
    public void addLast(T elem)
    {
        _Array[_Tail] = elem;
        _Tail++;
    }
    public T gerLast()
    {
        final T t = (T) _Array[_Tail];
        return t;
    }
    public T removeLast()
    {
        Object temp = _Array[0];
        _Array[_Tail] = null;
        _Tail--;
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
