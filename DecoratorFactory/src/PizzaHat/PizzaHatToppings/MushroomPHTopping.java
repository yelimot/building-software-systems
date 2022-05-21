package PizzaHat.PizzaHatToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class MushroomPHTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public MushroomPHTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Mushroom";
	}

	public int getCost() {
		return 7 + pizza.getCost();
	}

}
