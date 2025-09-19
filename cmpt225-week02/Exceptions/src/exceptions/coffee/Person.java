package exceptions.coffee;


/**
 * @author Igor
 *
 */
public class Person {
    
    private String name;
     
    public Person(String nm){ 
        name=nm;
    }
    
    public String getName() {
		return name;
	}
    
    public void drinkCoffee(Coffee c) throws TooColdException, TooHotException
    {
    	if (c.getTemperature()==Coffee.JUST_RIGHT)
    	{
    		System.out.println(name + " is drinking coffee"); 
    	}
    	else if (c.getTemperature()==Coffee.TOO_COLD)
    	{
    		throw new TooColdException(c);
    	}
    	else if (c.getTemperature()==Coffee.TOO_HOT)
    	{
    		throw new TooHotException(this.name, c);
    	}
    }
    
     
}
