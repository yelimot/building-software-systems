package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class RedPepperPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public RedPepperPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Red Pepper";
	}

	public int getCost() {
		return 8 + pizza.getCost();
	}

}
