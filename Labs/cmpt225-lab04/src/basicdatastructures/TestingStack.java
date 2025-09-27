package basicdatastructures;

import basicdatastructures.stack.*;

/**
 * Testing stacks 
 *   
 * @author Igor
 *
 */

public class TestingStack {

	public static <T> void printStack(Stack<T> s) {
		if (s.isEmpty())
			return;
		T obj = s.pop();
		printStack(s);
		s.push(obj);
		System.out.println(obj);
		
//		Stack<T> tmpStack = new StackLinkedListBased<T>();
//		T obj = null;
//		while (!s.isEmpty()) {
//			obj = s.pop();
//			tmpStack.push(obj);
//		}
//		
//		// now s is empty
//		// tmpStack has everything is the reversed order
//		// need to pour everything back
//		while (!tmpStack.isEmpty()) {
//			obj = tmpStack.pop();
//			System.out.println(obj);
//			s.push(obj);
//		}
	}

	/**
	 * checks if the two stacks have the same items in the same order
	 * compare two objects using .equals() method
	 *
	 * when the function returns, s1 and s2 must be in 
	 * the same state as they were originally 
	 */
	public static <T> boolean areEqual(Stack<T> s1, Stack<T> s2) {
		// TODO implement me
		return false;
	}

	/**
	 * reverses the stack
	 */
	public static <T> void reverseStack(Stack<T> s) {
		// TODO implement me
	}

	/**
	 * creates a copy of the orig
	 * when the function returns, orig must be in 
	 * the same state as it was originally 
	 */
	public static <T> Stack<T> cloneStack(Stack<T> orig) {
		// TODO implement me
		return null;
	}


	/**
	 * swaps the content of s1 and s2
	 */
	public static <T> void swapStacks(Stack<T> s1, Stack<T> s2) {
		// TODO implement me
	}

	public static void main(String[] args) {
		Stack<Integer> s = new StackArrayBased<Integer>();
		s.push(1);	// s = [1]
		s.push(2);	// s = [1,2]
		s.push(3);	// s = [1,2,3]
		s.push(4);	// s = [1,2,3,4]
		s.push(5);	// s = [1,2,3,4]
		
		System.out.println("printing s: ");
		printStack(s);
		System.out.println();

		// add tests for each of the methods you implement:
		// areEqual()
		// reverseStack()
		// cloneStack()
		// swapStacks()
	}

}


