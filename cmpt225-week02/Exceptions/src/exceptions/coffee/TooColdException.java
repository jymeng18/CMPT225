package exceptions.coffee;

public class TooColdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3093845992318866528L;
	
	Coffee c;
	
	public TooColdException() {
		c = null;
	}

	public TooColdException(Coffee c) {
		this.c = c;
	}

}
