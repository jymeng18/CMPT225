package exceptions.coffee;

class VirtualCafe {
	
    public static void serveCustomer(Person customer, Coffee cup)
    {

    	try {
            customer.drinkCoffee(cup);
            System.out.printf("%s's coffee is just right.\n", customer.getName());
        }
        catch (TooColdException e) {
            System.out.printf("%s's coffee is too cold.\n", customer.getName());
            // Deal with the customer...
        }
        catch (TooHotException e) {
            System.out.printf("%s's coffee is too hot.\n", customer.getName());
            System.out.println("The error message is:\n" +e.getMessage());
            // Deal with the customer...
        }
    	finally {
			System.out.println("Clear the table");
		}
    }

    
    public static void main(String[] args) {
		Coffee coffee = new Coffee(Coffee.JUST_RIGHT);
		Coffee coldCoffee = new Coffee(Coffee.TOO_COLD);
		Coffee hotCoffee = new Coffee(Coffee.TOO_HOT);
		
		Person p = new Person("John");
		
		serveCustomer(p,coffee);
		System.out.println("-----------");
		serveCustomer(p,coldCoffee);
		System.out.println("-----------");
		serveCustomer(p,hotCoffee);
	}
}
