package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class BasilLeavesMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public BasilLeavesMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Basil Leaves";
	}

	public int getCost() {
		return 6 + pizza.getCost();
	}

}
