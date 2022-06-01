package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SausagePGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SausagePGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Sausage";
	}

	public int getCost() {
		return 9 + pizza.getCost();
	}

}
