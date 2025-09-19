package basicdatastructures;

import myclasses.GroceryItem;
import basicdatastructures.mylinkedlists.MyLinkedList;


/**
 * Testing Linked List
 *   
 * @author Igor
 *
 */

public class TestLinkedList{
	public static void main(String[] args) {
		MyLinkedList<Integer> ints = new MyLinkedList<Integer>();
		ints.addToHead(7);
		// 7
		ints.addToHead(5);
		// 5->7
		ints.addToHead(3);
		ints.addToHead(1);
		// 1->3->5->7

		
		MyLinkedList<GroceryItem> groceryList = new MyLinkedList<GroceryItem>();
		groceryList.addToHead(new GroceryItem("Milk", 3, 4.32));
		// head -> Milk
		groceryList.addToHead(new GroceryItem("Yogurt", 2, 1.17));
		// head -> Yogurt -> Milk
		groceryList.addToHead(new GroceryItem("Cheese", 3, 10.99));
		// head -> Cheese -> Yogurt -> Milk
		groceryList.addAfter(groceryList.head(), new GroceryItem("Pringles", 2, 2.99));
		// head -> Cheese -> Pringles -> Yogurt -> Milk
		
		System.out.println(groceryList);

		MyLinkedList<String> strings = new MyLinkedList<String>();
		strings.addToHead("ABC");
		strings.addToHead("XYZ");
		strings.addToHead("BC");
		strings.addToHead("FGC");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToHead("123");
		strings.addToHead("456");
		strings.addToHead("ABC");
		strings.addToHead("ABC");
		strings.addToTail("000");
		strings.addToTail("111");
		strings.addToTail("222");
		
		System.out.println(strings);
		
		System.out.println("removeAllOccurences(\"ABC\");");
		strings.removeAllOccurences("ABC");
		System.out.println(strings);

		System.out.println("remove head and tail");
		
		strings.set(3, "NEW-ELT");

		System.out.println("strings[0] = " +strings.get(0));
		System.out.println("strings[3] = " +strings.get(3));
		System.out.println(strings);
		
	}
}