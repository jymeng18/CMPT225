package carbuilder;

import java.util.ArrayList;

public class RunCarBuilder{

	public static void main(String[] args) {
		
		ArrayList<Car> cars = CarBuilder.buildCars("Toyota", "Corolla", 2020, 10);
		if (cars.get(0) == cars.get(1))
			System.out.println("cars.get(0) == cars.get(1) as pointers");
		else
			System.out.println("cars.get(0) != cars.get(1) as pointers");
		
		if (cars.get(0).equals(cars.get(1)))
			System.out.println("cars.get(0) is equal to cars.get(1) as make, model, year");
		else
			System.out.println("cars.get(0) is not equal to cars.get(1)");
		
	}
	
}
