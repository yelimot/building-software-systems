package PizzaHat;

import Generic.AbstractPizza;

public class PepperoniPHPizza extends AbstractPizza {
    
    public PepperoniPHPizza() { 
        description = "Pepperoni Pizza"; 
    }
   
    public int getCost() {  return 48; }
}
