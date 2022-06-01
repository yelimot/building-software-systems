package PizzaHat;

import Generic.AbstractPizza;

public class RanchHousePHPizza extends AbstractPizza {
    
    public RanchHousePHPizza() { 
        description = "Ranch House Pizza"; 
    }
   
    public int getCost() {  return 50; }
}
