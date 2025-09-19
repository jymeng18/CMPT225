package exceptions;
/**
 *   
 * @author Igor
 *
 */
public class Circle {

	protected Point center;
	protected int radius;
	
	public Circle(int x, int y,int r)
	{
		setCenter(new Point(x, y));
		setRadius(r);
	}
	
	public Circle(Point c,int r)
	{
		setCenter(c);
		setRadius(r);
	}
	
	public Point getCenter() {
		return center;
	}
	
	public void setCenter(Point c) {
		this.center = c;
	}

	public void setRadius(int rad) {
		if (rad >= 0)
			this.radius = rad;
		else {
			IllegalArgumentException ex = new IllegalArgumentException("radius < 0"); 
			throw ex;
		}
	}
	
	public int getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	
	public static void main(String[] args) {

		Point p1 = new Point(1, 10);
		Circle c1 = new Circle(p1,5);
		try {
			c1.setRadius(-3);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("error message:  \n" + e.getMessage());
			
			System.out.println("-------");
			
			System.out.println("e.toString(): \n" +e.toString());
			
			System.out.println("-------");

			System.out.println("e.printStackTrace(): ");
			e.printStackTrace();	
			System.out.println("-------");
			System.out.println("Stacks Trace:");
			StackTraceElement[] stackTrace = e.getStackTrace();
			for(StackTraceElement elt : stackTrace)
				System.out.println(elt.toString());
			
		}
	}
}

