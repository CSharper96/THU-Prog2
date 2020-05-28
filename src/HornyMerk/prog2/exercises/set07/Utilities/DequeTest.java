package HornyMerk.prog2.exercises.set07.Utilities;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class DequeTest {

    @Test
    public void testDeque() {
        Deque<Double> d = new Deque<Double>(10);
        assertTrue(d.isEmpty());
        d.addFirst(2.0);
        assertFalse(d.isEmpty());
        assertEquals(1, d.size());
    }

    @Test
    public void testAddFirstRemoveAndRepeat() {
        Deque<Double> d = new Deque<Double>(10);
        d.addFirst(1.0);
        assertEquals(Double.valueOf(1.0),d.removeFirst());
        d.addLast(2.0);
        assertEquals(Double.valueOf(2.0),d.removeLast());

        d.addFirst(3.0);
        assertEquals(Double.valueOf(3.0),d.removeLast());
        d.addLast(4.0);
        assertEquals(Double.valueOf(4.0),d.removeFirst());
    }


    @Test
    public void testIterator() {
        Deque<Double> d = new Deque<Double>(10);
        for (Double i = 0d; i < 10; i++) {
            d.addLast(i);
        }
        int i = 0;
        for(Double cur: d) {
            System.out.println(i);
            assertEquals(Double.valueOf(i), Double.valueOf(cur));
            i++;
        }
        assertEquals(Double.valueOf(i), Double.valueOf(10));
    }


    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemoveFirstOnEmpty() {
        Deque<Double> q = new Deque<Double>(10);
        q.removeFirst();
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemeveLastOnEmpty() {
        Deque<Double> d = new Deque<Double>(10);
        d.removeLast();
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testIteratorNextOnEmpty() {
        Deque<Double> d = new Deque<Double>(10);
        Iterator<Double> i = d.iterator();
        assertFalse(i.hasNext());
        i.next();

    }

    @Test(expected=NullPointerException.class)
    public void testAddFirstWithNull() {
        Deque<Double> d = new Deque<Double>();
        d.addFirst(null);
    }

    @Test(expected=NullPointerException.class)
    public void testAddLastWithNull() {
        Deque<Double> d = new Deque<Double>();
        d.addLast(null);
    }
}
