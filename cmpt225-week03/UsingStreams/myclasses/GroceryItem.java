package myclasses;
/**
 * contains the data of a person
 *   
 * @author Igor
 *
 */

public class GroceryItem {

	protected String name;
	protected int quantity;
	protected double pricePerUnit;
	
		
	public GroceryItem(String name, int quantity, double pricePerUnit) {
		this.name = name;
		this.quantity = quantity;
		this.pricePerUnit= pricePerUnit;
	}
		
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
		
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	
	public String toString() {
		return	name + ": " + quantity + " units for " + pricePerUnit + " per unit";
	}
	

}


	