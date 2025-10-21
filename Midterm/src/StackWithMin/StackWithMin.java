package StackWithMin;
import java.util.*;

public class StackWithMin <T extends Comparable<T>>{
    Stack<T> mainStack;
    Stack<T> minStack;

    public StackWithMin(){
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T item){
        mainStack.push(item);
        if(minStack.isEmpty() || item.compareTo(minStack.peek()) < 0){
            minStack.push(item);
        }
    }
    public T pop(){
        T poppedVal = mainStack.pop();
        if(poppedVal.compareTo(minStack.peek()) == 0){
            minStack.pop();
        }
        return poppedVal;
    }

    public int size(){
        return mainStack.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T getMin(){
        return minStack.pop();
    }
}
