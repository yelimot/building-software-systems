package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class BasilLeavesPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public BasilLeavesPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Basil Leaves";
	}

	public int getCost() {
		return 5 + pizza.getCost();
	}

}
