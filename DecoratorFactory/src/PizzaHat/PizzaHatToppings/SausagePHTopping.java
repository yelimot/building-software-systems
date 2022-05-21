package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SausagePHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SausagePHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Sausage";
	}

	public int getCost() {
		return 8 + pizza.getCost();
	}

}
