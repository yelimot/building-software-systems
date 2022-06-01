package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class CherryTomatoPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public CherryTomatoPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Cherry Tomato";
	}

	public int getCost() {
		return 7 + pizza.getCost();
	}

}
