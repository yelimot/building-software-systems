package MamaJones.MamaJonesToppings;

import Generic.AbstractPizza;
import Generic.AbstractToppingDecorator;

public class JalapenoMJTopping extends AbstractToppingDecorator {

	AbstractPizza pizza;

	public JalapenoMJTopping(AbstractPizza pizza) {
		this.pizza = pizza;
	}

	public String getDescription() {
		return pizza.getDescription() + ", Mushroom";
	}

	public int getCost() {
		return 6 + pizza.getCost();
	}

}
