package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class OlivePGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public OlivePGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Olive";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
