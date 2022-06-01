package Factory;

import Factory.Generic.AbstractPizzaFactory;
import Generic.AbstractPizza;
import PizzaHat.BarbequeChickenPHPizza;
import PizzaHat.MargheritaPHPizza;
import PizzaHat.PepperoniPHPizza;
import PizzaHat.RanchHousePHPizza;
import PizzaHat.PizzaHatToppings.BasilLeavesPHTopping;
import PizzaHat.PizzaHatToppings.CherryTomatoPHTopping;
import PizzaHat.PizzaHatToppings.JalapenoPHTopping;
import PizzaHat.PizzaHatToppings.MushroomPHTopping;
import PizzaHat.PizzaHatToppings.OlivePHTopping;
import PizzaHat.PizzaHatToppings.ParmesanCheesePHTopping;
import PizzaHat.PizzaHatToppings.PepperoniPHTopping;
import PizzaHat.PizzaHatToppings.RicottaCheesePHTopping;
import PizzaHat.PizzaHatToppings.SalamiPHTopping;
import PizzaHat.PizzaHatToppings.SausagePHTopping;
import PizzaHat.PizzaHatToppings.SweetCornPHTopping;

public class PizzaHatFactory extends AbstractPizzaFactory {

	@Override
	protected AbstractPizza createPizza(int type) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			return new RanchHousePHPizza();
		case 2:
			return new MargheritaPHPizza();
		case 3:
			return new PepperoniPHPizza();
		case 4:
			return new BarbequeChickenPHPizza();
		default:
			break;
		}
		return null;
	}

	@Override
	protected AbstractPizza createTopping(int type, AbstractPizza orderedPizza) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			return new ParmesanCheesePHTopping(orderedPizza);
		case 2:
			return new OlivePHTopping(orderedPizza);
		case 3:
			return new SweetCornPHTopping(orderedPizza);
		case 4:
			return new RicottaCheesePHTopping(orderedPizza);
		case 5:
			return new SausagePHTopping(orderedPizza);
		case 6:
			return new PepperoniPHTopping(orderedPizza);
		case 7:
			return new SalamiPHTopping(orderedPizza);
		case 8:
			return new BasilLeavesPHTopping(orderedPizza);
		case 9:
			return new CherryTomatoPHTopping(orderedPizza);
		case 10:
			return new MushroomPHTopping(orderedPizza);
		case 11:
			return new JalapenoPHTopping(orderedPizza);
		default:
			break;
		}
		return null;
	}

}