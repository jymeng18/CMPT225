public class InverseHashString {

	public static String inverseHash(int h) {
		return null;
	}
	
	public static void main(String[] args) {
		String ret = inverseHash(12345);

		if (ret.hashCode() == 12345)
			System.out.println("Well done!");
		else
			System.out.println("Wrong");
	}
}
