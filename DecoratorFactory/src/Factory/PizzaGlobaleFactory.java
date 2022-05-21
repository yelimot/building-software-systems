package Factory;

import Factory.Generic.AbstractPizzaFactory;
import Generic.AbstractPizza;
import PizzaGlobale.BarbequeChickenPGPizza;
import PizzaGlobale.FourCheesesPGPizza;
import PizzaGlobale.GoatCheesePGPizza;
import PizzaGlobale.MargheritaPGPizza;
import PizzaGlobale.SmokedRibsPGPizza;
import PizzaGlobale.PizzaGlobaleToppings.BasilLeavesPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.CherryTomatoPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.MushroomPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.OlivePGTopping;
import PizzaGlobale.PizzaGlobaleToppings.ParmesanCheesePGTopping;
import PizzaGlobale.PizzaGlobaleToppings.PastramiPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.PepperoniPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.RedPepperPGTopping;
import PizzaGlobale.PizzaGlobaleToppings.RicottaCheesePGTopping;
import PizzaGlobale.PizzaGlobaleToppings.SausagePGTopping;
import PizzaGlobale.PizzaGlobaleToppings.SweetCornPGTopping;

public class PizzaGlobaleFactory extends AbstractPizzaFactory {

	@Override
	protected AbstractPizza createPizza(int type) {
		// TODO Auto-generated method stub
		switch(type) {
			case 1:
				return new GoatCheesePGPizza();
			case 2:
				return new MargheritaPGPizza();
			case 3:
				return new FourCheesesPGPizza();
			case 4:
				return new BarbequeChickenPGPizza();
			case 5:
				return new SmokedRibsPGPizza();
			default:
				break;
		}
		return null;
	}
	
	@Override
	protected AbstractPizza createTopping(int type, AbstractPizza orderedPizza) {
		// TODO Auto-generated method stub
		switch(type) {
			case 1:
				return new ParmesanCheesePGTopping(orderedPizza);
			case 2:
				return new OlivePGTopping(orderedPizza);
			case 3:
				return new SweetCornPGTopping(orderedPizza);
			case 4:
				return new RicottaCheesePGTopping(orderedPizza);
			case 5:
				return new RedPepperPGTopping(orderedPizza);
			case 6:
				return new SausagePGTopping(orderedPizza);
			case 7:
				return new PepperoniPGTopping(orderedPizza);
			case 8:
				return new PastramiPGTopping(orderedPizza);
			case 9:
				return new BasilLeavesPGTopping(orderedPizza);
			case 10:
				return new CherryTomatoPGTopping(orderedPizza);
			case 11:
				return new MushroomPGTopping(orderedPizza);
			default:
				break;
		}
		return null;
	}
	
}