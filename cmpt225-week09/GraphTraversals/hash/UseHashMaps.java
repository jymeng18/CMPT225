package hash;

import java.util.*;

public class UseHashMaps<T> {

	public static void main(String[] args) {
		HashSet<Integer> s = new HashSet<Integer>();
		
		s.add(1);
		s.add(4);
		s.add(7);
		
		System.out.println(s.contains(1));
		System.out.println(s.contains(20));
		

		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		m.put(2, 7);
		m.put(3, 8);
		
		System.out.println(m.get(2));
		System.out.println(m.get(3));
		System.out.println(m.get(20));

		HashMap<Integer, LinkedList<Integer>> listOfNeighbours;
		// key - a vertex
		// value - list of neighbors
		
		listOfNeighbours = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> n1 = new LinkedList<Integer>();
		n1.add(2);
		n1.add(3);
		n1.add(5);
		listOfNeighbours.put(1, n1);
		// adding 8 as a neighbor of 1
		listOfNeighbours.get(1).add(8);
		
	}
}
