package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class PepperoniMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public PepperoniMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Pepperoni";
	}

	public int getCost() {
		return 8 + pizza.getCost();
	}

}
