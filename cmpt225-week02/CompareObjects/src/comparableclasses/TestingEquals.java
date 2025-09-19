package comparableclasses;

/**
 * This program illustrates the .equals() method
 *   
 * @author Igor
 *
 */
public class TestingEquals{

	protected int ID;
	protected String name;
	
	public TestingEquals(int id, String n) {
		ID = id;
		name = n;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getID() {
		return ID;
	}
	
	
	@Override
	public String toString() {
		return this.name+this.ID;
	}

	@Override
	public boolean equals(Object otherObj) {
		if (this==otherObj)
			return true;
		if (otherObj==null)
			return false;
		if (!(otherObj instanceof TestingEquals))
			return false;

		TestingEquals other = (TestingEquals) otherObj; //downcasting
//		if ((this.ID == other.ID) && (this.name == other.name) ) // wrong
		if ((this.ID == other.ID) && this.name.equals(other.name))
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		TestingEquals c1 = new TestingEquals(0,"ABC");
		System.out.println("**class of c1 is : " + c1.getClass());

		TestingEquals c2 = new TestingEquals(0,"ABC");
		System.out.println("c1 and c2 are the same object: " + (c1 == c2));
		System.out.println("c1.equals(c2) = " +c1.equals(c2));

		System.out.println("-------------------------------------");
		
		String s1 = "ABC";
		String s2 = new String("ABC");
		String s3 = "ABC";
		System.out.println("s1.equals(s2) = " +s1.equals(s2));
		System.out.println("s1.equals(s3) = " +s1.equals(s3));
		System.out.println("s1 and s2 are the same object : " + (s1 == s2));
		System.out.println("s1 and s3 are the same object : " + (s1 == s3));
		
	}
	
}
