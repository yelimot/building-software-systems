package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SweetCornPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SweetCornPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Sweet Corn";
	}

	public int getCost() {
		return 3 + pizza.getCost();
	}

}
