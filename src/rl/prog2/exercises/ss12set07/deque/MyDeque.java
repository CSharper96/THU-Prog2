package rl.prog2.exercises.ss12set07.deque;

import java.util.Iterator;

/**
 * Simple implementation of a double ended queue with fixed capacity. Elements
 * can be added at the front and back in constant time (no element shifts are
 * performed). When reading from an empty deque or writing to a full deque, an
 * IllegalStateException is thrown.
 * 
 * @author Ruediger Lunde
 * 
 * @param <E>
 */
public class MyDeque<E> implements Iterable<E>{
	private E[] elements;
	private int first;
	private int last;
	private int size;

	/** Creates a deque with a fixed capacity. */
	@SuppressWarnings("unchecked")
	public MyDeque(int capacity) {
		elements = (E[]) new Object[capacity];
		first = 0;
		last = capacity() - 1;
	}

	/** Checks whether the deque contains elements or not. */
	public boolean isEmpty() {
		return size() == 0;
	}

	/** Checks whether the current size has reached the capacity. */
	public boolean isFull() {
		return size() == capacity();
	}

	/** Returns the number of elements currently maintained by the deque. */
	public int size() {
		return size;
	}

	/** Returns the capacity of the deque. */
	public int capacity() {
		return elements.length;
	}

	/**
	 * Returns the specified element. The index 0 means the element at the
	 * "first" position which is not necessary the element with array index 0!
	 */
	public E get(int index) {
		if (index < 0 || index >= size())
			throw new IllegalStateException("wrong index");
		return elements[(first + index) % capacity()];
	}

	/**
	 * Adds an element in front of the first element. No element shifts are
	 * performed.
	 */
	public void addFirst(E element) {
		if (isFull())
			throw new IllegalStateException("deque full");
		first = (capacity() + first - 1) % capacity();
		elements[first] = element;
		size++;
	}

	/**
	 * Removes the first element and returns it. No element shifts are
	 * performed.
	 */
	public E removeFirst() {
		if (isEmpty())
			throw new IllegalStateException("deque empty");
		E result = elements[first];
		first = (first + 1) % capacity();
		size--;
		return result;
	}

	/** Returns the first element. */
	public E getFirst() {
		if (isEmpty())
			throw new IllegalStateException("deque empty");
		return elements[first];
	}

	/**
	 * Adds an element behind the last element. No element shifts are performed.
	 */
	public void addLast(E element) {
		if (isFull())
			throw new IllegalStateException("deque full");
		last = (last + 1) % capacity();
		elements[last] = element;
		size++;
	}

	/**
	 * Removes the last element and returns it. No element shifts are performed.
	 */
	public E removeLast() {
		if (isEmpty())
			throw new IllegalStateException("deque empty");
		E result = elements[last];
		last = (capacity() + last - 1) % capacity();
		size--;
		return result;
	}

	/** Returns the last element. */
	public E getLast() {
		if (isEmpty())
			throw new IllegalStateException("deque empty");
		return elements[last];
	}

	/** Returns a string representation of the current state of the deque. */
	public String toString() {
		StringBuffer result = new StringBuffer("[ ");
		for (int i = 0; i < size(); i++)
			result.append(get(i) + " ");
		result.append("]");
		return result.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new MyDequeItr<E>(this);
	}
}
