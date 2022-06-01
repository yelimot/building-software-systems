package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class RicottaCheesePHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public RicottaCheesePHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Ricotta Cheese";
	}

	public int getCost() {
		return 5 + pizza.getCost();
	}

}
