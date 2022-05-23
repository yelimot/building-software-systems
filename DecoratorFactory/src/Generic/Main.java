package Generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Factory.MamaJonesFactory;
import Factory.PizzaGlobaleFactory;
import Factory.PizzaHatFactory;
import Factory.Generic.AbstractPizzaFactory;

//Driver class and method
class PizzaStore {
	public static void main(String args[]) {

		Scanner myScan = new Scanner(System.in); // Create a Scanner object

		List<AbstractPizza> orderedPizzas = new ArrayList<AbstractPizza>();

		System.out.println("Welcome!. (Type 123 to quit)\nPlease choose the pizza shop you "
				+ "want to give an order:\n1. Pizza Globale\n2. Pizza Hat\n3. Mama Jones’ Pizza");
		System.out.println("Choice: ");

		// scan0 pizza store selection
		String scan0 = myScan.nextLine();

		// scan1 for general menu and pizza selection
		int scan1;

		// scan2 for topping selection
		int scan2;

		while (!scan0.equals("123")) {

			// To-Do: General Menu conditional operations

			System.out.println("1. See or cancel your orders\r\n" + "2. Order pizza\r\n"
					+ "3. Go back to pizza shop selection\r\n" + "" + "Choice: ");
			scan1 = myScan.nextInt();
			myScan.nextLine();
			if (scan1 == 1) {
				while (true) {
					System.out.println("Your Orders:");
					switch (scan0) {
					case "1":
						System.out.println("Pizza Shop: Pizza Globale ");
						break;
					case "2":
						System.out.println("Pizza Shop: Pizza Hat ");
						break;
					case "3":
						System.out.println("Pizza Shop: Mama Jones' Pizza ");
						break;
					}
					int total = 0;
					if (!orderedPizzas.isEmpty()) {
						for (int i = 1; i <= orderedPizzas.size(); i++) {
							System.out.println(i + "- " + orderedPizzas.get(i - 1).getDescription());
							System.out.println("Cost: " + orderedPizzas.get(i - 1).getCost() + "₺");
							total += orderedPizzas.get(i - 1).getCost();
						}
					}
					System.out.println("Total Number of Pizzas: " + orderedPizzas.size());
					System.out.println("Total Cost: " + total + "₺");
					if (!orderedPizzas.isEmpty()) {
						System.out.println("Do you want to cancel your order? (Y/N) ");
						String scan4 = myScan.nextLine();
						if (scan4.equalsIgnoreCase("Y")) {
							System.out.println("Please choose the pizza you want to cancel");
							int scan5 = myScan.nextInt();
							myScan.nextLine();
							orderedPizzas.remove(scan5 - 1);
							if (orderedPizzas.isEmpty()) {
								break;
							}
						} else {
							break;
						}
					} else {
						break;
					}
				}
			} else if (scan1 == 2) {
				if (scan0.equals("1")) {
					AbstractPizzaFactory pizzaGlobale = new PizzaGlobaleFactory();
					System.out.println("Select the pizza: Pizzas:\r\n"
							+ "1- Goat Cheese Pizza – Info: Tomato Sauce, Mozzarella Cheese, Goat Cheese – Cost: 60₺\r\n"
							+ "2- Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
							+ "60₺\r\n"
							+ "3- 4 Cheeses Pizza – Info: Tomato Sauce, Mozzarella Cheese, Roquefort Cheese, Parmesan \r\n"
							+ "Cheese, Feta Cheese – Cost: 55₺\r\n"
							+ "4- Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
							+ "Sauce – Cost: 54₺\r\n"
							+ "5- Smoked Ribs Pizza – Info: Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, \r\n"
							+ "Parmesan Cheese – Cost: 70₺");
					scan1 = myScan.nextInt();
					myScan.nextLine();
					AbstractPizza pizza = pizzaGlobale.orderPizza(scan1);
					System.out.println("Do you want to add toppings? (Y/N)");
					String scan3 = myScan.nextLine();
					while (scan3.equalsIgnoreCase("y")) {
						System.out.println(
								"What toppings do you want: Toppings:\r\n" + "1- Parmesan Cheese – Cost: 5₺\r\n"
										+ "2- Olive – Cost: 4₺\r\n" + "3- Sweet Corn – Cost: 3₺\r\n"
										+ "4- Ricotta Cheese – Cost: 4₺\r\n" + "5- Red Pepper – Cost: 8₺\r\n"
										+ "6- Sausage – Cost: 9₺\r\n" + "7- Pepperoni – Cost: 8₺\r\n"
										+ "8- Pastrami – Cost 10₺\r\n" + "9- Basil Leaves – Cost 6₺\r\n"
										+ "10- Cherry Tomato – Cost 7₺\r\n" + "11- Mushroom – Cost: 6₺\r" + "");
						scan2 = myScan.nextInt();
						myScan.nextLine();
						pizza = pizzaGlobale.addTopping(scan2, pizza);
						System.out.println("Do you want to add toppings? (Y/N)");
						scan3 = myScan.nextLine();
					}
					orderedPizzas.add(pizza);
				} else if (scan0.equals("2")) {
					AbstractPizzaFactory pizzaHat = new PizzaHatFactory();
					System.out.println("Select the pizza: Pizzas:\r\n"
							+ "1- Ranch House Pizza – Info: Tomato Sauce, Mozzarella Cheese, Salami, Mushroom – Cost: 50₺\r\n"
							+ "2- Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
							+ "53₺\r\n"
							+ "3- Pepperoni Pizza – Info: Tomato Sauce, Mozzarella Cheese, Pepperoni – Cost: 48₺\r\n"
							+ "4- Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
							+ "Sauce – Cost: 57₺");
					scan1 = myScan.nextInt();
					myScan.nextLine();
					AbstractPizza pizza = pizzaHat.orderPizza(scan1);
					System.out.println("Do you want to add toppings? (Y/N)");
					String scan3 = myScan.nextLine();
					while (scan3.equalsIgnoreCase("y")) {
						System.out.println("Toppings:\r\n" + "1- Parmesan Cheese – Cost: 4₺\r\n"
								+ "2- Olive – Cost: 3₺\r\n" + "3- Sweet Corn – Cost: 3₺\r\n"
								+ "4- Ricotta Cheese – Cost: 5₺\r\n" + "5- Sausage – Cost: 8₺\r\n"
								+ "6- Pepperoni – Cost: 8₺\r\n" + "7- Salami – Cost 9₺\r\n"
								+ "8- Basil Leaves – Cost 5₺\r\n" + "9- Cherry Tomato – Cost 6₺\r\n"
								+ "10- Mushroom – Cost: 7₺\r\n" + "11- Jalapeno – Cost: 4₺");
						scan2 = myScan.nextInt();
						myScan.nextLine();
						pizza = pizzaHat.addTopping(scan2, pizza);
						System.out.println("Do you want to add toppings? (Y/N)");
						scan3 = myScan.nextLine();
					}
					orderedPizzas.add(pizza);
				} else if (scan0.equals("3")) {
					AbstractPizzaFactory mamaJones = new MamaJonesFactory();
					System.out.println("Select the pizza: Pizzas:\r\n"
							+ "1- Aegean Pizza – Info: Tomato Sauce, Mozzarella Cheese, Olive, Red Onion, Red Pepper – Cost: \r\n"
							+ "55₺\r\n"
							+ "2- Margherita Pizza – Info: Tomato Sauce, Mozzarella Cheese, Cherry Tomato, Basil Leaves – Cost: \r\n"
							+ "58₺\r\n"
							+ "3- Mixed Pizza – Info: Tomato Sauce, Mozzarella Cheese, Pepperoni, Sausage, Salami, Green \r\n"
							+ "Pepper – Cost: 63₺\r\n"
							+ "4- Barbeque Chicken Pizza – Info: Tomato Sauce, Mozzarella Cheese, Chicken Slices, Barbeque \r\n"
							+ "Sauce, Jalapeno – Cost: 68₺\r\n"
							+ "5- Smoked Ribs Pizza – Info: Tomato Sauce, Mozzarella Cheese, Smoked Ribs, Arugula Leaves, \r\n"
							+ "Parmesan Cheese – Cost: 72₺");
					scan1 = myScan.nextInt();
					myScan.nextLine();
					AbstractPizza pizza = mamaJones.orderPizza(scan1);
					System.out.println("Do you want to add toppings? (Y/N)");
					String scan3 = myScan.nextLine();
					while (scan3.equalsIgnoreCase("y")) {
						System.out.println(
								"What toppings do you want: Toppings:\r\n" + "1- Parmesan Cheese – Cost: 5₺\r\n"
										+ "2- Olive – Cost: 3₺\r\n" + "3- Ricotta Cheese – Cost: 5₺\r\n"
										+ "4- Sausage – Cost: 7₺\r\n" + "5- Pepperoni – Cost: 7₺\r\n"
										+ "6- Salami – Cost 8₺\r\n" + "7- Basil Leaves – Cost 7₺\r\n"
										+ "8- Cherry Tomato – Cost 7₺\r\n" + "9- Jalapeno – Cost: 4₺");
						scan2 = myScan.nextInt();
						myScan.nextLine();
						pizza = mamaJones.addTopping(scan2, pizza);
						System.out.println("Do you want to add toppings? (Y/N)");
						scan3 = myScan.nextLine();
					}
					orderedPizzas.add(pizza);
				}
			} else if (scan1 == 3) {
				orderedPizzas.clear();
				System.out.println("Welcome!. (Type 123 to quit)\nPlease choose the pizza shop you "
						+ "want to give an order:\n1. Pizza Globale\n2. Pizza Hat\n3. Mama Jones’ Pizza");
				System.out.println("Choice: ");

				// scan0 pizza store selection
				scan0 = myScan.nextLine();
			}
			else if (scan1 == 123) {
				break;
			}
		}

		myScan.close();
	}
}
