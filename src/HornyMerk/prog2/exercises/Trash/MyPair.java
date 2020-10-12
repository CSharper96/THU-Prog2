package HornyMerk.prog2.exercises.Trash;

import java.util.Collection;

public class MyPair<E>
{
    E element1;
    E element2;

    public MyPair(E first, E second)
    {
        element1 = first;
        element2 = second;
    }
    public E getElement1()
    {
        return element1;
    }
    public E getElement2()
    {
        return element2;
    }
}
