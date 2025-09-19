import singleton.*;
/**
 *
 *SingletonClient
 *   
 * @author Igor
 *
 */
public class SingletonClient {

	

	public static void main(String[] args) {
		
		Singleton s = Singleton.getInstance();
		s.printVal();

		Singleton s2 =  Singleton.getInstance();
		s2.printVal();
		
		s.setVal(222);

		System.out.print("s2.");
		s2.printVal();

//		Singleton s3 = new Singleton(); // can't use it. Constructor is private
		
		System.out.println("the objects are equal:" + (s == s2));
	}

}


