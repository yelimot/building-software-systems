package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class ParmesanCheesePHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public ParmesanCheesePHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Parmesan Cheese";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
