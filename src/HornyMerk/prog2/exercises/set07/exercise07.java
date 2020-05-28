package HornyMerk.prog2.exercises.set07;

import HornyMerk.prog2.exercises.set07.Utilities.Deque;

public class exercise07
{
    public static void main(String[] args)
    {
        Deque<Integer> deque = new Deque<Integer>(10);
        for(int i = 0; i < 3; i++)
            deque.addFirst(i);
        System.out.println(deque);
        for(int i = 3; i < 6; i++)
            deque.addLast(i);
        System.out.println(deque);
        for(int i = 0; i < 2; i++)
            deque.removeFirst();
        System.out.println(deque);
        while(!deque.isEmpty())
            deque.removeLast();
        System.out.println(deque);
        for(int i = 0; i < 8; i++)
            deque.addLast(i);
        System.out.println(deque);
    }
}
