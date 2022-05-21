package Factory;

import Factory.Generic.AbstractPizzaFactory;
import Generic.AbstractPizza;
import MamaJones.AegeanMJPizza;
import MamaJones.BarbequeChickenMJPizza;
import MamaJones.MargheritaMJPizza;
import MamaJones.MixedMJPizza;
import MamaJones.SmokedRibsMJPizza;

public class MamaJonesFactory extends AbstractPizzaFactory {

	@Override
	protected AbstractPizza createPizza(int type) {
		// TODO Auto-generated method stub
		switch(type) {
			case 1:
				return new AegeanMJPizza();
			case 2:
				return new MargheritaMJPizza();
			case 3:
				return new MixedMJPizza();
			case 4:
				return new BarbequeChickenMJPizza();
			case 5:
				return new SmokedRibsMJPizza();
			default:
				break;
		}
		return null;
	}
	
}