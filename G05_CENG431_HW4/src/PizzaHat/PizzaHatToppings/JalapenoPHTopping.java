package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class JalapenoPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public JalapenoPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Jalapeno";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
