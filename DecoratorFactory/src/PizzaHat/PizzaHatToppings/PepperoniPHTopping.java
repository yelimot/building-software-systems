package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class PepperoniPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public PepperoniPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Pepperoni";
	}

	public int getCost() {
		return 8 + pizza.getCost();
	}

}
