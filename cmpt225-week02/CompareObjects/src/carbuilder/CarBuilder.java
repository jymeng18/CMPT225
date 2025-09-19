package carbuilder;

import java.util.ArrayList;

public class CarBuilder{

	public static ArrayList<Car> buildCars(String make, String model, int year, int count) {
		Car prototype = new Car(make, model, year);
		Car carToAdd;
		
		// create ArrayList with given capacity
		ArrayList<Car> listOfCars = new ArrayList<Car>(count);
		for (int i = 0; i < count; i++) {
			carToAdd = prototype.clone();
			listOfCars.add(carToAdd);
		}
		return listOfCars;
	}
}
