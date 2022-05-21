package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SalamiPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SalamiPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Salami";
	}

	public int getCost() {
		return 9 + pizza.getCost();
	}

}
