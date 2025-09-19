package staticvars;

import java.awt.Color;

/**
 * @author Igor
 *
 */
public class Bicycle {
    
	// data fields
	protected int gears;
	protected int speed;
    protected Color color;

    private static int createdBicycles = 0;
     
    public Bicycle(Color c, int g, int s){ 
        color = c;
        gears = g;
        speed = s;

        createdBicycles++;
    }
     
    public static int getNumberOfCreatedBicycles()    {
    	return createdBicycles;
    }
    

}
