package Factory.Generic;

import Generic.AbstractPizza;

public abstract class AbstractPizzaFactory {
	public AbstractPizza orderPizza(int type) {
		AbstractPizza pizza = createPizza(type);
		return pizza;
	}
	
	public AbstractPizza addTopping(int type, AbstractPizza orderedPizza) {
		AbstractPizza pizza = createTopping(type, orderedPizza);
		return pizza;
	}

	protected abstract AbstractPizza createPizza(int type);
	protected abstract AbstractPizza createTopping(int type, AbstractPizza orderedPizza);
}
