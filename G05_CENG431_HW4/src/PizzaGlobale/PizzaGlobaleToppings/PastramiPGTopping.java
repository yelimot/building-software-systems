package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class PastramiPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public PastramiPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Pastrami";
	}

	public int getCost() {
		return 10 + pizza.getCost();
	}

}
