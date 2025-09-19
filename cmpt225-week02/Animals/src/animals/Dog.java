package animals;

public class Dog implements Animal{

	protected String breed;
	protected String color;
	protected String name;
	
	public Dog(String breed, String color, String name)
	{
		setBreed(breed);
		setColor(color);
		setName(name);
	}
	
	public String getBreed() {
		return breed;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public void draw()
	{
		// drawing implemenation...
	}

	public String makeSound()
	{
		return "woof-woof";
	}

	public String toString()
	{
		return "Dog: Breed = " + breed + " Color = " + color + " Name = " + name;
	}

	
}


