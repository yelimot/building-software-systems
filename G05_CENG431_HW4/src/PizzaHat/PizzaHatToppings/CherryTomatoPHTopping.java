package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class CherryTomatoPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public CherryTomatoPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Cherry Tomato";
	}

	public int getCost() {
		return 6 + pizza.getCost();
	}

}
