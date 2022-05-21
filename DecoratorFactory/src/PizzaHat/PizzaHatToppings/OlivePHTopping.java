package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class OlivePHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public OlivePHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Olive";
	}

	public int getCost() {
		return 3 + pizza.getCost();
	}

}
