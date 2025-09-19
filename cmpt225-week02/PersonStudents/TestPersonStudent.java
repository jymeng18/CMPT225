/**
 * Test the classes Person and Student
 *  
 * @author Igor
 *
 */
public class TestPersonStudent {

	public static void main(String[] args) {
		
		Person Tom = new Person(123, "Tom", "Sawyer", Person.MALE); 
		System.out.println("Tom = " + Tom.getFullName());
		
		Person AnotherPtrToTom = Tom;
		System.out.println("AnotherPtr= " + AnotherPtrToTom.getFullName());

		System.out.println("----------");
		Tom.setFirstName("Tom2");
		System.out.println("Tom = " + Tom.getFullName());
		System.out.println("AnotherPtr= " + AnotherPtrToTom.getFullName());

		
		System.out.println("------");

		Student Huck = new Student(456, "Huck", "Finn", Person.MALE);
		System.out.println("Print Huck using getFullName()::");
		System.out.println(Huck.getFullName());

		System.out.println("Print Huck using toString()::");
		System.out.println(Huck); // same as Huck.toString()

		System.out.println("------");

		
		Person p = Huck; // Huck is of type Student, ok to assign it to its superclass
		System.out.println("Print p::");
		System.out.println(p); // calls toString() of Student
	
		System.out.println("Print p2::");
		Student p2 = (Student) p; // ok since we really know p is Huck of type Student
		System.out.println(p2);
	
		System.out.println("-----------");

		Student s;
		s = Huck;	// ok since Huck is of type Student
		System.out.println(s.getFullName());

		// s = Tom; /// !!! Compile Time Exception !!! Tom is of type Person
		
		
		// s = (Student) Tom; // ClassCast Exception
		// s expects to have student ID, but Tom doesn't have a student ID 
		
		// Student objStudent
		// Person objPerson
		// Student s = objStudent; - ok
		// Person p = objStudent; - ok 
		// Person p = objPerson; - ok
		// Student s = objPerson; - not ok
		
		
	}
	
}


