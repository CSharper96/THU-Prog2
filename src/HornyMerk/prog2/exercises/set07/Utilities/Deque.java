package HornyMerk.prog2.exercises.set07.Utilities;

import java.util.Arrays;
import java.util.Iterator;

public class Deque <T > implements Iterable, Cloneable{

    private T[] _Array;
    private int _FirstIndex;
    private int _LastIndex;

    public Deque(int capacity)
    {
        _Array = (T[]) new Object[capacity];
        _FirstIndex = 0;
        _LastIndex = capacity-1;
    }

    public boolean isEmpty()
    {
        boolean check = true;
        for (int i = 0; i < _Array.length; i++)
        {
            if(_Array[i] != null)
            {
                check = false;
            }
        }
        return check;
    }

    public boolean isFull(){
        boolean check = true;
        for (int i = 0; i < _Array.length; i++)
        {
            if(_Array[i] == null)
            {
                check = false;
            }
        }
        return check;
    }

    public int size()
    {
        int count = 0;
        for (int i = 0; i < _Array.length; i++)
        {
            if(_Array[i] != null)
            {
                count++;
            }
        }
        return count;
    }

    public int capacity()
    {
        return _Array.length;
    }

    public T get(int i)
    {
        if(!isEmpty() && i <= size() && i >= 0)
        {
            int ind = _FirstIndex;
            for (int j = 0; j < i; j++)
            {
                if(ind < capacity() - 1) ind++;
                else ind = 0;
            }
            return _Array[ind];
        }
        else if(i > size() || i < 0)
        {
            System.out.println("Wrong index.");
            return null;
        }
        else
        {
            System.out.println("Deque is empty.");
            return null;
        }
    }

    public void addFirst(T elem)
    {
        if(!isFull())
        {
            _FirstIndex = (capacity() + _FirstIndex - 1) % capacity();
            _Array[_FirstIndex] = elem;
        }
        else System.out.println("Deque is already full.");
    }

    public T getFirst()
    {
        if(!isEmpty()) return _Array[_FirstIndex];
        else return null;
    }

    public T removeFirst()
    {
        if(!isEmpty())
        {
            T res = _Array[_FirstIndex];
            _Array[_FirstIndex] = null;
            _FirstIndex = (capacity() + _FirstIndex + 1) % capacity();

            return res;
        }
        else return null;
    }

    public void addLast(T elem)
    {
        if(!isFull())
        {
            _LastIndex = (capacity() + _LastIndex + 1) % capacity();
            _Array[_LastIndex] = elem;
        }
        else System.out.println("Deque is already full.");
    }

    public T getLast()
    {
        if(!isEmpty())
            return _Array[_LastIndex];

        System.out.println("Deque is empty.");
        return null;
    }

    public T removeLast()
    {
        if(!isEmpty())
        {
            T result = _Array[_LastIndex];
            _Array[_LastIndex] = null;
            _LastIndex = (capacity() + _LastIndex - 1) % capacity();
            return result;
        }

        System.out.println("Deque is empty.");
        return null;
    }

    @Override
    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("[ ");
        int ind = _FirstIndex;
        for (int i = 0; i < capacity(); i++)
        {
            if(_Array[ind] != null)
                str.append(_Array[ind].toString() + " ");

            if(ind < capacity() - 1)
                ind++;

            else
                ind = 0;
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public Iterator iterator()
    {
        return new MyIterator(this);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Deque<T> myDeque = null;
        myDeque = (Deque<T>) super.clone();
        myDeque._Array = (T[]) this._Array.clone();
        return myDeque;
    }

    public static class MyIterator<E extends Comparable> implements Iterator
    {
        private Deque<E> deque;
        private E first;

        public MyIterator(Deque<E> deque)
        {
            this.deque = deque;
            first = deque.getFirst();
        }

        @Override
        public boolean hasNext()
        {
            return first != null;
        }

        @Override
        public E next()
        {
            E res = deque.getFirst();
            deque.removeFirst();
            first = deque.getFirst();
            return res;
        }
    }
}
