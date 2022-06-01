package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class RicottaCheeseMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public RicottaCheeseMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Ricotta Cheese";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
