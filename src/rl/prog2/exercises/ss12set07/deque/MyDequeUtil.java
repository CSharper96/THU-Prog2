package rl.prog2.exercises.ss12set07.deque;

/**
 * Contains some utilities for deques.
 * @author Ruediger Lunde
 *
 */
public class MyDequeUtil {

	/**
	 * Returns a deque, which contains the elements of deque1 as
	 * well as deque2. The argument deques are not changed by this operation.
	 */
	public static <T> MyDeque<T> merge(MyDeque<T> deque1, MyDeque<T> deque2) {
		MyDeque<T> result = new MyDeque<T>(deque1.capacity()+deque2.capacity());
		for (int i = 0; i < deque1.size(); i++) {
			result.addLast(deque1.get(i));
		}
		for (int i = 0; i < deque2.size(); i++) {
			result.addLast(deque2.get(i));
		}
		return result;
	}
	
	/**
	 * Returns those elements from the given deque, which are less than the
	 * reference element.
	 * @param deque A deque
	 * @param elem A reference element
	 */
	public static <T extends Comparable<? super T>> MyDeque<T> selectLess(MyDeque<T> deque, T elem) {
		MyDeque<T> result = new MyDeque<T>(deque.capacity());
		for (int i = 0; i < deque.size(); i++) {
			T currElem = deque.get(i);
			if (currElem.compareTo(elem) < 0)
				result.addLast(currElem);
		}
		return result;
	}
	
	/** Never instantiate this class! */
	private MyDequeUtil() {
	}
}
