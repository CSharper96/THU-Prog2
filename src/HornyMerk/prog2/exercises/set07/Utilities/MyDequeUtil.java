package HornyMerk.prog2.exercises.set07.Utilities;

public class MyDequeUtil {

    public static <T extends Comparable> Deque<T> merge(Deque<T> deque1, Deque<T> deque2) throws CloneNotSupportedException
    {
        Deque<T> result = new Deque<T>(deque1.capacity() + deque1.capacity());
        Deque<T> deq1 = (Deque<T>) deque1.clone();
        Deque<T> deq2 = (Deque<T>) deque2.clone();

        while(!deq2.isEmpty())
        {
            T temp = deq2.removeLast();
            result.addFirst(temp);
        }

        while(!deq1.isEmpty())
        {
            T temp = deq1.removeLast();
            result.addFirst(temp);
        }

        return result;
    }

    public static <T extends Comparable> Deque<T> selectLess(Deque<T> deque, T comp) throws CloneNotSupportedException
    {
        Deque<T> result = new Deque<T>(deque.size());
        Deque<T> tempDeque = (Deque<T>) deque.clone();
        while (!tempDeque.isEmpty())
        {
            T tempObj = tempDeque.removeLast();
            if(tempObj.compareTo(comp) < 0)
                result.addFirst(tempObj);
        }
        return result;
    }
}
