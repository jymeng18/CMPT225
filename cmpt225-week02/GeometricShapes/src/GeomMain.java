import java.util.Random;

import geomerticshapes.*;

class GeomMain {

	public static GeometricShape createRandomGeometricObject()
	{
		Random r = new Random();
		switch (r.nextInt(3)) {
			case 0:
				return new Circle(r.nextInt(100), r.nextInt(100), r.nextInt(50));
			case 1:
				return new Square(r.nextInt(100), r.nextInt(100), r.nextInt(50));
			case 2:
				return new Rectangle(r.nextInt(100), r.nextInt(100), r.nextInt(50), r.nextInt(50));
		}
		return null;
	}
	
	public static void main(String[] args) {
		GeometricShape[] array = new GeometricShape[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = createRandomGeometricObject();
		}
		
		System.out.println("Using the classical for loop");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		//  even better to use for each loop
		System.out.println("--\nUsing for each loop");
		for (GeometricShape obj : array) {
			System.out.println(obj);
		}
		/*	this is equivalent to: 
		 *	for (int i = 0; i < array.length; i++) {
		 * 		obj = array[i];
		 * 		System.out.println(obj);
		 *  }
		 *  In particular, obj.moveTo(...) will not have any effect on the array
		 */
		
	}

}




