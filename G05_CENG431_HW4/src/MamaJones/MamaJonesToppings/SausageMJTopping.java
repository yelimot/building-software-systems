package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class SausageMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public SausageMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Sausage";
	}

	public int getCost() {
		return 9 + pizza.getCost();
	}

}
