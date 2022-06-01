package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class RicottaCheesePGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public RicottaCheesePGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Ricotta Cheese";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
