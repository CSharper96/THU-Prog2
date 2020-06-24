package rl.prog2.exercises.ss12set07.deque;

/**
 * Test class for the deque implementation. The expected output is as follows:
 * <pre>
 * [ 2 1 0 ]
 * [ 2 1 0 3 4 5 ]
 * [ 0 3 4 5 ]
 * [ ]
 * [ 0 1 2 3 4 5 6 7 ]
 * [ 0 1 2 3 4 5 6 7 0 1 2 3 4 5 6 7 ]
 * [ 0 1 2 3 4 ]
 * 0, 1, 2, 3, 4, 5, 6, 7,
 * </pre> 
 * @author Ruediger Lunde
 *
 */
public class MyDequeTest {

	public static void main(String[] args) {
		MyDeque<Integer> deque = new MyDeque<Integer>(10);
		for (int i = 0; i < 3; i++)
			deque.addFirst(i);
		System.out.println(deque);
		for (int i = 3; i < 6; i++)
			deque.addLast(i);
		System.out.println(deque);
		for (int i = 0; i < 2; i++)
			deque.removeFirst();
		System.out.println(deque);
		while (!deque.isEmpty())
			deque.removeLast();
		System.out.println(deque);
		for (int i = 0; i < 8; i++)
			deque.addLast(i);
		System.out.println(deque);
		System.out.println(MyDequeUtil.merge(deque, deque));
		System.out.println(MyDequeUtil.selectLess(deque, 5));
		for (int elem : deque)
			System.out.print(elem + ", ");
	}
}
