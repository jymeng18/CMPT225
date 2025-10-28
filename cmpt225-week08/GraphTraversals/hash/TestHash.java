package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import graph.Vertex;

public class TestHash<T> {

	public static void main(String[] args) {
		String a = "ABC";
		System.out.println(a.hashCode());
		String b = "ACB";
		System.out.println(b.hashCode());
		String c = "A123D";
		System.out.println(c.hashCode());

		System.out.println("-------------");
		Vertex<String> a1 = new Vertex<String>("A");
		Vertex<String> a2 = new Vertex<String>("A");
		Vertex<String> a3 = new Vertex<String>("A");
		
		System.out.println("hashCode(a1) = " + a1.hashCode());
		System.out.println("hashCode(a2) = " + a2.hashCode());
		System.out.println("hashCode(a3) = " + a3.hashCode());

		Vertex<String> bc1 = new Vertex<String>("BC");
		Vertex<String> bc2 = new Vertex<String>("BC");
		System.out.println("hashCode(bc1) = " + bc2.hashCode());
		System.out.println("hashCode(bc2) = " + bc1.hashCode());
		
		System.out.println("-----------");
		
		MyClass2 mc1 = new MyClass2(1, 2, 3, "Hello");
		MyClass2 mc2 = new MyClass2(1, 2, 4, "Hello");
		MyClass2 mc3 = new MyClass2(1, 2, 4, "Good bye");
		MyClass2 mc4 = new MyClass2(1, 2, 0, "Help");
		MyClass2 mc5 = new MyClass2(1, 2, 0, "Help");
		MyClass2 mc6 = new MyClass2(100, 2001, 2001, "z");
		// ex: create an object whose hashCode has 3 zeros in the end
		
		System.out.println("mc1.hash = " + mc1.hashCode());
		System.out.println("mc2.hash = " + mc2.hashCode());
		System.out.println("mc3.hash = " + mc3.hashCode());
		System.out.println("mc4.hash = " + mc4.hashCode());
		System.out.println("mc5.hash = " + mc5.hashCode());
		System.out.println("mc6.hash = " + mc6.hashCode());
 
	}
}
