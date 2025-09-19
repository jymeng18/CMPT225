package animals;

public class Cow implements Animal {

	protected String color;
	protected String name;
	protected int weight;
	
	public Cow(String color, String name, int weight)
	{
		setColor(color);
		setName(name);
		setWeight(weight);
	}

	public String getColor() {
		return color;
	}

	public int getWeight() {
		return weight;
	}
	
	public String getName() {
		return name;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void draw()
	{
		// drawing implemenation...
	}

	public String makeSound()
	{
		return "moo";
	}


  	public String toString()
 	{
		return "Cow: Color = " + color + " Name = " + name + " Weight = " + weight;
	}

	
}

