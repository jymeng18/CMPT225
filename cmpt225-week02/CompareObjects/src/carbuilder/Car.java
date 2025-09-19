package carbuilder;

public class Car{

	static int nextSerial = 12355; // starting with some magica number 
	protected String make;
	protected String model;
	protected int year;
	protected int uniqueSerialID;
	
	public Car(String carMake, String carModel, int carYear) {
		make = carMake;
		model = carModel;
		year = carYear;
		uniqueSerialID = generateID();
	}
	
	public boolean equals(Car otherCar) {
		if (this == otherCar)
			return true;

		// compare make, model, year
		// note that we do not compare serialID
		if (make.equals(otherCar.make)
				&& model.equals(otherCar.model)
				&& year==otherCar.year)
			return true;
		else
			return false;
	}
	
	public Car clone() {
		return new Car(make, model, year); // creates a new car with another ID
	}

	public String getMake() {
		return make;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getYear() {
		return year;
	}
	
	public int getSerialID() {
		return uniqueSerialID;
	}
	
	int generateID() {
		nextSerial=+19;
		return nextSerial;
	}

}