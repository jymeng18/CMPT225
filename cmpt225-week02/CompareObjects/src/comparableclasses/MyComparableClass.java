package comparableclasses;

import java.util.Arrays;

/**
 * This program illustrates the Comparable interface
 *   
 * @author Igor
 *
 */
public class MyComparableClass implements Comparable<MyComparableClass> {

	protected int ID;
	protected String name;
	
	public MyComparableClass(int id, String n) {
		ID = id;
		name = n;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	
	
	@Override
	/**
	 * compare first by ID
	 * if IDs are equal, compare by name
	 */
	public int compareTo(MyComparableClass other) {
		if (this.ID != other.ID)
			return this.ID - other.ID;
		else // this.ID == other.ID
			return name.compareTo(other.name); // uses String.compareTo() 
	}

	/**
	 * compare first by ID
	 * if IDs are equal, compare by name
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (!(other instanceof MyComparableClass))
			return false;

		MyComparableClass otherObj = (MyComparableClass) other;
		return (this.ID == otherObj.ID && this.name.equals(otherObj.name));
	}
	
	@Override
	public String toString() {
		
		return this.name+this.ID;
	}
	
	public static void main(String[] args) {

		MyComparableClass[] c = new MyComparableClass[5];
		c[0] = new MyComparableClass(0,"ABC");
		c[1] = new MyComparableClass(1,"ABC");
		c[2] = new MyComparableClass(2,"ABC");
		c[3] = new MyComparableClass(1,"XYZ");
		c[4] = new MyComparableClass(2,"ABC");

		if (c[1].compareTo(c[2]) > 0)
			System.out.printf("c[1] > c[2] \n");
		else if (c[1].compareTo(c[2]) < 0)
			System.out.printf("c[1] < c[2] \n");
		else
			System.out.printf("c[1] == c[2] \n");
	
		if (c[1].compareTo(c[3]) > 0)
			System.out.printf("c[1] > c[3] \n");
		else if (c[1].compareTo(c[3]) < 0)
			System.out.printf("c[1] < c[3] \n");
		else
			System.out.printf("c[1] == c[3] \n");
	
		System.out.printf("Sorting the array:...\n");
		Arrays.sort(c); // implements a sorting algorithm of arrays of comparable types
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i].toString());
		}
		System.out.printf("\n");

		System.out.println("Another way to print:");
		Arrays.stream(c)
			.forEach(myObj -> System.out.println(myObj));
}
	
}
