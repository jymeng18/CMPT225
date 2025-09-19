package geomerticshapes;

public class Circle extends GeometricShape{

	protected int radius;
	
	/**
	 * 
	 * @param initX
	 * @param initY
	 * @param initR - radius
	 * initX, initY is the center of the circle
	 */
	public Circle(int initX, int initY, int initR) {
		super(initX, initY);
		radius= initR;
	}

    public void setRadius(int rad) {
        if (rad >= 0)
            this.radius = rad;
        else {
            IllegalArgumentException ex = new IllegalArgumentException("radius < 0");
            throw ex;
        }
    }

	public void draw() {
		// drawing implementation...
	}

// 	Let's see what happens if we don't implement this
	@Override
	public String toString() {
		return "Circle: center=(" + x + "," + y +"), radius = " + radius;
	}

}


