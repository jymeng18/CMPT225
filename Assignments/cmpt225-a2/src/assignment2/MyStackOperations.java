package assignment2;

import basicdatastructures.stack.*;

import java.util.NoSuchElementException;

public class MyStackOperations {
	/**
	 * Returns the number of elements in s.
	 */
	public static <T> int size(Stack<T> s) {
        // Make sure object of type Stack is not null
        assert s != null;

		Stack<T> temp1 = new StackLinkedListBased<>();
        int count = 0;

        while(!s.isEmpty()){
            temp1.push(s.pop());
            count++;
        }

        // Restore original data
        while(!temp1.isEmpty()){
            s.push(temp1.pop());
        }

		return count;
	}

	/**
	 * Removes the bottom element from the stack, and returns it.
     * The remaining elements are kept in the same order.
     * If s is empty, the method throws NoSuchElementException.
	 */
    public static <T> T removeBottom(Stack<T> s) {
		if(s.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }

        // Pop all elements in the stack except for the bottom one
        Stack<T> temp = new StackLinkedListBased<>();
        while(size(s) > 1){
            temp.push(s.pop()); // temp holds it in reverse order
        }
        T bottom = s.pop(); // 'bottom' value

        // Restore order in 's'
        while(!temp.isEmpty()){
            s.push(temp.pop());
        }
		return bottom;
	}

	/**
	 * Reverses the order of the elements in s.
	 */
	public static <T> void reverse(Stack<T> s) {
        assert s != null;

		Stack<T> temp1 = new StackLinkedListBased<>();
        Stack<T> temp2 = new StackLinkedListBased<>();

        // Reverse order, store in temp1
        while(!s.isEmpty()){
            temp1.push(s.pop());
        }

        // Make order normal and store in temp2
        while(!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }

        // Restore back in 's' with reversed order
        while(!temp2.isEmpty()){
            s.push(temp2.pop());
        }
	}

	/**
	 * Checks if the two stacks have the same items in the same order. The items in
	 * the queues are compared using == operator.
	 */
	public static <T> boolean areEqual(Stack<T> s1, Stack<T> s2) {
		if(s1 == null || s2 == null){
            return false;
        }
        if(s1.isEmpty() && s2.isEmpty()){
            return true; // empty stacks are the same
        }

		if(size(s1) != size(s2)){
            return false; // size must be matching
        }
        Stack<T> temp1 = new StackLinkedListBased<>();
        Stack<T> temp2 = new StackLinkedListBased<>();
        boolean isEqual = true;

        while(!s1.isEmpty()){
            T value1 = s1.pop();
            T value2 = s2.pop();

            temp1.push(value1);
            temp2.push(value2);

            if(value1 != value2){
                isEqual = false;
            }
        }

        // Restore both stacks
        while(!temp1.isEmpty()){
            s1.push(temp1.pop());
        }
        while(!temp2.isEmpty()){
            s2.push(temp2.pop());
        }

        return isEqual;
	}
}
