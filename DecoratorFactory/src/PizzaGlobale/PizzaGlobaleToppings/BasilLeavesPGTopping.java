package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class BasilLeavesPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public BasilLeavesPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Basil Leaves";
	}

	public int getCost() {
		return 6 + pizza.getCost();
	}

}
