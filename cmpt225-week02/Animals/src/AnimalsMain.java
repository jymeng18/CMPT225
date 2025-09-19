import java.util.Random;

import animals.Animal;
import animals.Cow;
import animals.Dog;

class AnimalsMain {

	public static Animal createRandomAnimal()
	{
		Random r = new Random();
		switch (r.nextInt(3)) {
			case 0:
				return new Cow("Pink", "name" + r.nextInt(10), r.nextInt(200) );
			case 1:
				return new Dog("Spaniel", "Blue", "name" + r.nextInt(100));
			case 2:
				return new Dog("Shepherd", "Gold", "name" + r.nextInt(100));
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		Animal[] array = new Animal[5]; // creates an empty array that can hold 5 Animals
		for (int i = 0; i < array.length; i++) {
			array[i] = createRandomAnimal();
		}

		for (Animal animal : array) {
			System.out.print(animal + " says "); // animal really calls toString()
			System.out.println(animal.makeSound());
			// note that makeSound uses polymorphism mechanism
			// it's calling makeSound of Cow or of Dog without us specifying it
		}
	}


}

