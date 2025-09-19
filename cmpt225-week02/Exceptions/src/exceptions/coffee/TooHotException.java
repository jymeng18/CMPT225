package exceptions.coffee;

public class TooHotException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9064614936433189505L;

	Coffee c;
	
	public TooHotException() {
		c = null;
	}

	public TooHotException(String s) {
		super("Customer's name: " +s + ". Coffee is too hot");
	}

	public TooHotException(Coffee c) {
		this.c = c;
	}

	public TooHotException(String s, Coffee c)
	{
		super("Customer's name: " +s + ". Coffee is too hot");
		this.c = c;
	}

}
