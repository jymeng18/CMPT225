package exceptions.coffee;

public class Coffee {

	public final static int TOO_COLD = -1;
	public final static int TOO_HOT = 0;
	public final static int JUST_RIGHT = 1;
	
	public int temperature;
	
	public Coffee(int temp)
	{
		temperature = temp;
	}
	
	public int getTemperature() {
		return temperature;
	}
}
