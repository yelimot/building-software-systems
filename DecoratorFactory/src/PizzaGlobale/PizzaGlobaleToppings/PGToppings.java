package PizzaGlobale.PizzaGlobaleToppings;

import Generic.AbstractPizza;

class PGToppings {
}

class ParmesanCheesePGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public ParmesanCheesePGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Parmesan Cheese";
    }
    public int getCost() { return 5 + pizza.getCost(); }
}

class OlivePGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public OlivePGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olive";
    }
    public int getCost() { return 4 + pizza.getCost(); }
}

class SweetCornPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public SweetCornPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Sweet Corn";
    }
    public int getCost() { return 3 + pizza.getCost(); }
}

class RicottaCheesePGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public RicottaCheesePGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Ricotta Cheese";
    }
    public int getCost() { return 4 + pizza.getCost(); }
}

class RedPepperPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public RedPepperPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Red Pepper";
    }
    public int getCost() { return 8 + pizza.getCost(); }
}

class SausagePGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public SausagePGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Sausage";
    }
    public int getCost() { return 9 + pizza.getCost(); }
}

class PepperoniPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public PepperoniPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }
    public int getCost() { return 8 + pizza.getCost(); }
}

class PastramiPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public PastramiPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Pastrami";
    }
    public int getCost() { return 10 + pizza.getCost(); }
}

class BasilLeavesPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public BasilLeavesPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Basil Leaves";
    }
    public int getCost() { return 6 + pizza.getCost(); }
}

class CherryTomatoPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public CherryTomatoPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Cherry Tomato";
    }
    public int getCost() { return 7 + pizza.getCost(); }
}

class MushroomPGTopping {
    // We need a reference to obj we are decorating
    AbstractPizza pizza;
 
    public MushroomPGTopping(AbstractPizza pizza) { 
        this.pizza = pizza; 
    }

    public String getDescription() {
        return pizza.getDescription() + ", Mushroom";
    }
    public int getCost() { return 6 + pizza.getCost(); }
}
