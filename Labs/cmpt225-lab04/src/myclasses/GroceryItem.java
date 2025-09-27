package myclasses;
/**
 * contains the data of a person
 *   
 * @author Igor
 *
 */

public class GroceryItem {

	public String name;
	public int quantity;
	public double pricePerUnit;
	
		
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


	