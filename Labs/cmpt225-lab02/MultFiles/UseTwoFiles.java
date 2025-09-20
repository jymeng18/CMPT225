public class UseTwoFiles {

	public static void main(String[] args) {
		
		A aObj = new A(5);
		System.out.println("aObj.data = " + aObj.getData());

		System.out.println("set aObj.data to 10");
		aObj.setData(10);

		System.out.println("New value of aObj.data is " + aObj.getData());
	}
}
