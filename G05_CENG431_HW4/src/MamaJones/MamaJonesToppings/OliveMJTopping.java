package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class OliveMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public OliveMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Olive";
	}

	public int getCost() {
		return 4 + pizza.getCost();
	}

}
