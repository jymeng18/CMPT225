package basicdatastructures;

import basicdatastructures.mylinkedlists.MyLinkedList;
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


	public static void main(String[] args) {
		Stack<Integer> s = new StackArrayBased<Integer>();
		s.push(1);	// s = [1]
		s.push(2);	// s = [1,2]
		s.push(3);	// s = [1,2,3]
		s.push(4);	// s = [1,2,3,4]
		System.out.println(s.pop()); // print 4  s becomes [1,2,3]
		
		System.out.println("printing s: ");
		printStack(s);
		System.out.println();

		s.push(5);
		System.out.println("added5, printing s: ");
		printStack(s);
	
	}

}


