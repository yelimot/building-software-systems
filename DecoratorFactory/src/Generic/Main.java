package Generic;

import java.util.Scanner;

import Factory.PizzaGlobaleFactory;
import Factory.PizzaHatFactory;
import Factory.Generic.AbstractPizzaFactory;

//Driver class and method
class PizzaStore {
	public static void main(String args[]) {
		// Order new pizza
		AbstractPizzaFactory pizzaGlobalFactory = new PizzaGlobaleFactory();
		AbstractPizza pizzaGlobalPizza1 = pizzaGlobalFactory.orderPizza(1);
		// System.out.println( pizza.getDescription() + " Cost :" + pizza.getCost());
		
		AbstractPizzaFactory pizzaHatFactory = new PizzaHatFactory();
		AbstractPizza pizzaHatPizza1 = pizzaHatFactory.orderPizza(1);

		// Decoration with topping
		pizzaGlobalPizza1 = pizzaGlobalFactory.addTopping(3, pizzaGlobalPizza1);
		pizzaGlobalPizza1 = pizzaGlobalFactory.addTopping(5, pizzaGlobalPizza1);
		
		pizzaHatPizza1 = pizzaHatFactory.addTopping(7, pizzaHatPizza1);
		pizzaHatPizza1 = pizzaHatFactory.addTopping(10, pizzaHatPizza1);

		System.out.println(pizzaGlobalPizza1.getDescription() + "Cost :" + pizzaGlobalPizza1.getCost());
		
		System.out.println(pizzaHatPizza1.getDescription() + "Cost :" + pizzaHatPizza1.getCost());
		
		Scanner myScan = new Scanner(System.in);  // Create a Scanner object
	    
	    
	    System.out.println("Welcome!. (Type 123 to quit)\n1. See or cancel your orders\r\n"
	    		+ "2. Order another pizza\r\n"
	    		+ "3. Go back to pizza shop selection\r\n"
	    		+ ""
	    		+ "Choice: ");
	  
	    // scan0 general menu selection
	    String scan0 = myScan.nextLine();
	    
	    // scan1 for pizza store selection
	    String scan1;
	    
	    // scan2 for topping selection
	    int scan2;
	    
	    while (!(scan0.equals("123"))) {
	    	
	    	// To-Do: General Menu conditional operations
	    	System.out.println("Please choose the pizza shop you want to give an order:\n1. Pizza Globale\n2. Pizza Hat\n3. Mama Jones’ Pizza");
	    	
		    scan1 = myScan.nextLine();
		    System.out.println("Choice: ");
	    	if (scan1.equals("1")) {
	    		System.out.println("Select the pizza: Pizzas:\r\n"
	    				+ "• Goat Cheese Pizza – Info: Tomato Sauce, Mozzarella Cheese, Goat Cheese – Cost: 60₺\r\n"
	    				+ "• Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
	    				+ "60₺\r\n"
	    				+ "• 4 Cheeses Pizza – Info: Tomato Sauce, Mozzarella Cheese, Roquefort Cheese, Parmesan \r\n"
	    				+ "Cheese, Feta Cheese – Cost: 55₺\r\n"
	    				+ "• Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
	    				+ "Sauce – Cost: 54₺\r\n"
	    				+ "• Smoked Ribs Pizza – Info: Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, \r\n"
	    				+ "Parmesan Cheese – Cost: 70₺\r\n");
	    		System.out.println("\nWhat toppings do you want: Toppings:\r\n"
	    				+ "1 Parmesan Cheese – Cost: 5₺\r\n"
	    				+ "2 Olive – Cost: 4₺\r\n"
	    				+ "3 Sweet Corn – Cost: 3₺\r\n"
	    				+ "4 Ricotta Cheese – Cost: 4₺\r\n"
	    				+ "5 Red Pepper – Cost: 8₺\r\n"
	    				+ "6 Sausage – Cost: 9₺\r\n"
	    				+ "7 Pepperoni – Cost: 8₺\r\n"
	    				+ "8 Pastrami – Cost 10₺\r\n"
	    				+ "9 Basil Leaves – Cost 6₺\r\n"
	    				+ "10 Cherry Tomato – Cost 7₺\r\n"
	    				+ "11 Mushroom – Cost: 6₺\r\n"
	    				+ "");
	    		scan2 = myScan.nextInt();
	    	} else if (scan1.equals("2")) {
	    		System.out.println("Select the pizza: Pizzas:\r\n"
	    				+ "• Ranch House Pizza – Info: Tomato Sauce, Mozzarella Cheese, Salami, Mushroom – Cost: 50₺\r\n"
	    				+ "• Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
	    				+ "53₺\r\n"
	    				+ "• Pepperoni Pizza – Info: Tomato Sauce, Mozzarella Cheese, Pepperoni – Cost: 48₺\r\n"
	    				+ "• Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
	    				+ "Sauce – Cost: 57₺");
	    		System.out.println("\nToppings:\r\n"
	    				+ "1 Parmesan Cheese – Cost: 4₺\r\n"
	    				+ "2 Olive – Cost: 3₺\r\n"
	    				+ "3 Sweet Corn – Cost: 3₺\r\n"
	    				+ "4 Ricotta Cheese – Cost: 5₺\r\n"
	    				+ "5 Sausage – Cost: 8₺\r\n"
	    				+ "6 Pepperoni – Cost: 8₺\r\n"
	    				+ "7 Salami – Cost 9₺\r\n"
	    				+ "8 Basil Leaves – Cost 5₺\r\n"
	    				+ "9 Cherry Tomato – Cost 6₺\r\n"
	    				+ "10 Mushroom – Cost: 7₺\r\n"
	    				+ "11 Jalapeno – Cost: 4₺");
	    		scan2 = myScan.nextInt();
	    	} else if (scan1.equals("3")) {
	    		System.out.println("Select the pizza: Pizzas:\r\n"
	    				+ "• Aegean Pizza – Info: Tomato Sauce, Mozzarella Cheese, Olive, Red Onion, Red Pepper – Cost: \r\n"
	    				+ "55₺\r\n"
	    				+ "• Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
	    				+ "58₺\r\n"
	    				+ "• Mixed Pizza – Info: Tomato Sauce, Mozzarella Cheese, Pepperoni, Sausage, Salami, Green \r\n"
	    				+ "Pepper – Cost: 63₺\r\n"
	    				+ "• Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
	    				+ "Sauce, Jalapeno – Cost: 68₺\r\n"
	    				+ "• Smoked Ribs Pizza – Info: Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, \r\n"
	    				+ "Parmesan Cheese – Cost: 72₺");
	    		System.out.println("\nWhat toppings do you want: Toppings:\r\n"
	    				+ "• Parmesan Cheese – Cost: 5₺\r\n"
	    				+ "• Olive – Cost: 3₺\r\n"
	    				+ "• Ricotta Cheese – Cost: 5₺\r\n"
	    				+ "• Sausage – Cost: 7₺\r\n"
	    				+ "• Pepperoni – Cost: 7₺\r\n"
	    				+ "• Salami – Cost 8₺\r\n"
	    				+ "• Basil Leaves – Cost 7₺\r\n"
	    				+ "• Cherry Tomato – Cost 7₺\r\n"
	    				+ "• Jalapeno – Cost: 4₺");
	    		scan2 = myScan.nextInt();
	    	}
	    	
	    	scan1 = myScan.nextLine();
	    	
	    }
	    
	    myScan.close();
	}
}
