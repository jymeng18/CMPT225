package builder;

import java.util.ArrayList;
import java.util.stream.Stream;

import geomerticshapes.*;

/**
 *
 * Geometric Shape Builder Demo
 *   
 * @author Igor
 *
 */
public class BuilderDemo {

	public static void main(String[] args) {

		ArrayList<GeometricShape> list = new ArrayList<GeometricShape>();

		GeometricShapeBuilder builder = new GeometricShapeBuilder();
		GeometricShape geomShape = null;

//		old fashion style
//		builder = builder.setShapeType("Circle");
//		builder = builder.setX(0);
//		builder = builder.setY(0);
//		builder = builder.setRadius(100);
//		geomShape = builder.createShape();
//		list.add(geomShape);

		// nicer
		// geomShape = builder.setShapeType("circle")
		geomShape = builder.setShapeType(GeometricShapeBuilder.CIRCLE) // use constants
				.setX(0)
				.setY(0)
				.setRadius(100)
				.createShape();
		list.add(geomShape);

		builder.setRadius(200);	// modify our previous specifications
		list.add(builder.createShape()); // add it to the list


		geomShape = builder.setShapeType("Square")
				.setX(10)
				.setY(20)
				.setLength(50)
				.createShape();
		list.add(geomShape);

		// can do all in one line
		list.add(builder.setShapeType("Rectangle")
				.setX(40)
				.setY(50)
				.setLength(50)
				.setWidth(100)
				.createShape());

		

		System.out.println("--- Printing the list ---");
		list.stream()	
			.forEach(obj ->System.out.println(obj));


		System.out.println("\n--- Printing only the circles --- ");
		
		Stream<GeometricShape> s = list.stream();
		Stream<GeometricShape> s2 = s.filter(obj -> obj instanceof Circle);	
		s2.forEach(obj ->System.out.println(obj));
	}

}


