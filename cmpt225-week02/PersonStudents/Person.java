/**
 * contains the data of a person
 *   
 * @author Igor
 *
 */

// public class Person extends Object
public class Person {

	public static final int MALE = 1; 
	public static final int FEMALE = 2; 


	// no access modifiers means public for subclasses + package
	int ID;
	String firstName;
	String lastName;
	int gender;
	
	/**
	 * Class constructor - initializes the data fields
	 * 
	 * @param newID - ID of the person  
	 * @param newFirstName - person's first name
	 * @param newLastName - person's last name
	 * 
	 */
		
	public Person(int newID, String newFirstName, String newLastName,int newGender) {
		this.ID = newID;
		this.firstName = newFirstName;
		this.lastName = newLastName;
		this.gender = newGender;
	}
		

	public int getID() {
		return ID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getGender() {
		return gender;
	}
	
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String last) {
		lastName = last;
//		System.out.println("Person.setLastName(...)");
	}
	
	/**
	 * returns full name 
	 * 
	 * @return first name and last name
	 * 
	 */
	public String getFullName () {
		return firstName + " " + lastName;
	}
	
	public String toString() {
		return	"Name = " + getFullName() +
				"; ID = " + this.ID;
	}
	

}


	