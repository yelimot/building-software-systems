package Factory;

import Factory.Generic.AbstractPizzaFactory;
import Generic.AbstractPizza;
import MamaJones.AegeanMJPizza;
import MamaJones.BarbequeChickenMJPizza;
import MamaJones.MargheritaMJPizza;
import MamaJones.MixedMJPizza;
import MamaJones.SmokedRibsMJPizza;
import MamaJones.MamaJonesToppings.BasilLeavesMJTopping;
import MamaJones.MamaJonesToppings.CherryTomatoMJTopping;
import MamaJones.MamaJonesToppings.JalapenoMJTopping;
import MamaJones.MamaJonesToppings.OliveMJTopping;
import MamaJones.MamaJonesToppings.ParmesanCheeseMJTopping;
import MamaJones.MamaJonesToppings.PepperoniMJTopping;
import MamaJones.MamaJonesToppings.RicottaCheeseMJTopping;
import MamaJones.MamaJonesToppings.SalamiMJTopping;
import MamaJones.MamaJonesToppings.SausageMJTopping;

public class MamaJonesFactory extends AbstractPizzaFactory {

	protected AbstractPizza createPizza(int type) {
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

	protected AbstractPizza createTopping(int type, AbstractPizza orderedPizza) {
		switch(type) {
			case 1:
				return new ParmesanCheeseMJTopping(orderedPizza);
			case 2:
				return new OliveMJTopping(orderedPizza);
			case 3:
				return new RicottaCheeseMJTopping(orderedPizza);
			case 5:
				return new SausageMJTopping(orderedPizza);
			case 7:
				return new PepperoniMJTopping(orderedPizza);
			case 8:
				return new SalamiMJTopping(orderedPizza);
			case 9:
				return new BasilLeavesMJTopping(orderedPizza);
			case 10:
				return new CherryTomatoMJTopping(orderedPizza);
			case 11:
				return new JalapenoMJTopping(orderedPizza);
			default:
				break;
		}
		return null;
	}
	
}