package myclasses;
/**
 * contains the data of a person
 *   
 * @author Igor
 *
 */

public class Person {


	protected String firstName;
	protected String lastName;
	protected int age;
	
	/**
	 * Class constructor - initializes the data fields
	 * 
	 * @param firstName - person's first name
	 * @param lastName - person's last name
	 * @param age - person's age
	 * 
	 */
		
	public Person(String firstName, String lastName,int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
		

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return	"Name = " + firstName + " " + lastName + "; age = " + age;
	}
	

}


	