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
		Stack<T> temp1 = new StackLinkedListBased<T>();
        Stack<T> temp2 = new StackLinkedListBased<T>();
        boolean equal = true;

        while(!s1.isEmpty() && !s2.isEmpty()) {

            T item1 = s1.pop();
            T item2 = s2.pop();

            // Temporarily storing the value to easily restore it
            temp1.push(item1);
            temp2.push(item2);

            // Compare value
            if(!item1.equals(item2)) {
                equal = false;
            }
        }

        // Must have same # of items
        if(!s1.isEmpty() || !s2.isEmpty()) {
            equal = false;
        }

        // Restore stacks s1 s2 to original
        while(!temp1.isEmpty()){
            T item1 = temp1.pop();
            s1.push(item1);
        }
        while(!temp2.isEmpty()){
            T item2 = temp2.pop();
            s2.push(item2);
        }
		return equal;
	}

	/**
	 * reverses the stack
	 */
	public static <T> void reverseStack(Stack<T> s) {
		Stack<T> temp1 = new StackLinkedListBased<>();
        Stack<T> temp2 = new StackLinkedListBased<>();

       // Need to reverse it twice

        while(!s.isEmpty()){
            temp1.push(s.pop());
        }

        // Popping val from temp1 -> temp2 (Reverses again)
        while(!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }

        // Restore data but reversed
        while(!temp2.isEmpty()){
            s.push(temp2.pop());
        }
	}

	/**
	 * creates a copy of the orig
	 * when the function returns, orig must be in 
	 * the same state as it was originally 
	 */
	public static <T> Stack<T> cloneStack(Stack<T> orig) {
        Stack<T> cloned = new StackLinkedListBased<T>();
        Stack<T> temp =  new StackLinkedListBased<T>();

        // Pops from orig, pushes to temp
        while(!orig.isEmpty()){
            temp.push(orig.pop());
        }

        while (!temp.isEmpty()) {
            T item = temp.pop();
            cloned.push(item);
            orig.push(item);
        }

        // Security check
		if(cloned.isEmpty()){
            return null;
        }
        else{
            return cloned;
        }
	}


	/**
	 * swaps the content of s1 and s2
	 */
	public static <T> void swapStacks(Stack<T> s1, Stack<T> s2) {
		Stack<T> temp1 = new  StackLinkedListBased<>();
        Stack<T> temp2 = new  StackLinkedListBased<>();

        while(!s1.isEmpty()){
            temp1.push(s1.pop());
        }

        while(!s2.isEmpty()){
            temp2.push(s2.pop());
        }
        while(!temp1.isEmpty()){
            s1.push(temp1.pop());
        }
        while(!temp2.isEmpty()){
            s2.push(temp2.pop());
        }
	}

	public static void main(String[] args) {
		Stack<Integer> s = new StackArrayBased<Integer>();
		s.push(1);	// s = [1]
		s.push(2);	// s = [1,2]
		s.push(3);	// s = [1,2,3]
		s.push(4);	// s = [1,2,3,4]
		s.push(5);	// s = [1,2,3,4]

        Stack<Integer> x = new StackArrayBased<Integer>();
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(7);
        x.push(5);

		System.out.println();

        if(areEqual(x, s)) {
            System.out.println("Are Equal\n");
        }
        else{
            System.out.println("Are Not Equal\n");
        }

        System.out.println("Current Stack: ");
        printStack(s);
        System.out.println("Reversed: ");
        reverseStack(s);
        printStack(s);

        System.out.println("Clone Stack: ");
        Stack<Integer> y = cloneStack(s);
        printStack(y);

		// cloneStack()
		// swapStacks()
	}

}


