package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SweetCornPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SweetCornPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Sweet Corn";
	}

	public int getCost() {
		return 3 + pizza.getCost();
	}

}
