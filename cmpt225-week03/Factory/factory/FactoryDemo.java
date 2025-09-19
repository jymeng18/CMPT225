package factory;

import java.util.Iterator;
import java.util.LinkedList;

import geomerticshapes.*;

/**
 *
 * Geometric Shape Factory Demo
 *   
 * @author Igor
 *
 */
public class FactoryDemo {

	public static void main(String[] args) {
		GeometricShapeFactory factory = new GeometricShapeFactory();
		
		LinkedList<GeometricShape> list = new LinkedList<GeometricShape>();
		list.add(factory.createShape("circle"));
		list.add(factory.createShape("SqUaRe"));
		list.add(factory.createShape("rectangle"));
		
		// list will contain 3 geometric shapes
		
		Iterator<GeometricShape> iterator = null;
		for (iterator = list.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());
		
		GeometricShape shape = (GeometricShape)list.get(0);
		shape.moveTo(10, 20);
		Circle c =  (Circle) shape;
		c.setRadius(20);

		shape = (GeometricShape)list.get(1);
		shape.moveTo(-30, -40);
	
		System.out.println("\n---after changes---");
		for (iterator = list.iterator(); iterator.hasNext();)
			System.out.println(iterator.next());
	}
	
}


