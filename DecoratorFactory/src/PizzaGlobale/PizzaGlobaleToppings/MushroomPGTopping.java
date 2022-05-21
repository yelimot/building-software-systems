package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class MushroomPGTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public MushroomPGTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Mushroom";
	}

	public int getCost() {
		return 6 + pizza.getCost();
	}

}
