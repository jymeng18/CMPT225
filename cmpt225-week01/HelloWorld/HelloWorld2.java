public class HelloWorld2 {

	public static void main(String[] args) {
		System.out.print("--Hello--\n--World");
		System.out.println("***");
		
		int x = 3;
		System.out.println("x = " + x);
		
		int y = 5;
		int sum = x+y;
		System.out.println("x=" + x + "; y = " + y +
							"; sum = " + sum);
					
		String s = "ABC";
		String t = s + "XYZ";
		System.out.println("the string s is: " + s + "\nThe string t is: " + t + "\n");

		String r = "ABCXYZ";
		System.out.println("r = " + r + "\n");

		if (r == t)
			System.out.println("r and t are the same string");
		else
			System.out.println("r and t are not the same string");

		boolean eq = r.equals(t);
		System.out.println("*** r.equals(t) == " + eq);

		
		String q = t;
		if (q == t)
			System.out.println("q and t are the same string");
		else
			System.out.println("q and t are not the same string");

		if (q.equals(t))
			System.out.println("q.equals(t) == true");
		else

			System.out.println("q.equals(t) == false");
		
	
	}
}
