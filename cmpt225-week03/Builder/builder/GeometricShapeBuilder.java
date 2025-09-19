package builder;

import geomerticshapes.*;

/**
 *
 * GeometricShapeBuilder
 *   
 * @author Igor
 *
 */
public class GeometricShapeBuilder {

	public final static String CIRCLE = "Circle";
	
	private String shapeType;
	private int x;
	private int y;
	private int radius; // used for circle
	private int length;	// used for rectangle/square
	private int width;

	public GeometricShape createShape() {
		if(shapeType == null){
			return null;
			// or maybe throw an exception
		}		

		if(shapeType.equalsIgnoreCase(CIRCLE)){
			return new Circle(x,y,radius);

		} else if(shapeType.equalsIgnoreCase("RECTANGLE")){
			return new Rectangle(x,y,length,width);

		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square(x,y,length);
		}

		return null;
	}
	
	GeometricShapeBuilder setShapeType(String type) {
		this.shapeType = type;
		return this;
	}

	GeometricShapeBuilder setX(int x) {
		this.x = x;
		return this;
	}

	GeometricShapeBuilder setY(int y) {
		this.y = y;
		return this;
	}

	GeometricShapeBuilder setLength(int length) {
		this.length = length;
		return this;
	}

	GeometricShapeBuilder setWidth(int width) {
		this.width = width;
		return this;
	}

	GeometricShapeBuilder setRadius(int radius) {
		this.radius = radius;
		return this;
	}



}


