package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class ParmesanCheesePGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public ParmesanCheesePGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Parmesan Cheese";
	}

	public int getCost() {
		return 5 + pizza.getCost();
	}

}
