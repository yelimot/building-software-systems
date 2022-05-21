package Generic;

import Factory.PizzaGlobaleFactory;
import Factory.PizzaHatFactory;
import Factory.Generic.AbstractPizzaFactory;

//Driver class and method
class PizzaStore {
	public static void main(String args[]) {
		// order new pizza
		AbstractPizzaFactory pg = new PizzaGlobaleFactory();
		AbstractPizza pizza = pg.orderPizza(1);
		// System.out.println( pizza.getDescription() + " Cost :" + pizza.getCost());
		
		AbstractPizzaFactory ph = new PizzaHatFactory();
		AbstractPizza pizza2 = ph.orderPizza(1);

		// decorate it with topping
		pizza = pg.addTopping(3, pizza);
		pizza = pg.addTopping(5, pizza);
		
		pizza2 = ph.addTopping(7, pizza2);
		pizza2 = ph.addTopping(10, pizza2);

		System.out.println(pizza.getDescription() + "Cost :" + pizza.getCost());
		
		System.out.println(pizza2.getDescription() + "Cost :" + pizza2.getCost());
	}
}
