package rl.prog2.exercises.ss12set07.deque;

import java.util.Iterator;

/**
 * Implements an iterator for the generic class MyDeque. 
 * @author Ruediger Lunde
 */
public class MyDequeItr<E> implements Iterator<E> {
	private MyDeque<E> deque;
	private int curr;
	
	MyDequeItr(MyDeque<E> deque) {
		this.deque = deque;
	}
	
	@Override
	public boolean hasNext() {
		return curr < deque.size();
	}

	@Override
	public E next() {
		return deque.get(curr++);
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
		
	}

}
