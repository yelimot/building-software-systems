package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class CherryTomatoMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public CherryTomatoMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Cherry Tomato";
	}

	public int getCost() {
		return 7 + pizza.getCost();
	}

}
