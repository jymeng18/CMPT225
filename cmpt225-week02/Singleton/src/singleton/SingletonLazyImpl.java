package singleton;

/**
 * Singleton - lazy initialization
 *   
 * @author Igor
 *
 */
public class SingletonLazyImpl {

	private int val;
	
	//
	private static SingletonLazyImpl theUniqueInstance = null;
	
	private SingletonLazyImpl() {
		val = 10;
	}
	
	public void printVal()	{
		System.out.println("val = " + val);
	}
	
	public static SingletonLazyImpl getInstance()	{
		// not safe for multhitreading
		if (theUniqueInstance == null)
			theUniqueInstance = new SingletonLazyImpl();
			
		return theUniqueInstance;
	}
}


