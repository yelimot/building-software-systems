package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class ParmesanCheeseMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public ParmesanCheeseMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Parmesan Cheese";
	}

	public int getCost() {
		return 5 + pizza.getCost();
	}

}
