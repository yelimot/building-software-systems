package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class PepperoniPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public PepperoniPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Pepperoni";
	}

	public int getCost() {
		return 8 + pizza.getCost();
	}

}
