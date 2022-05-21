package Generic;

public abstract class AbstractPizza {
	public String description = "Unknown Pizza";
	 
    public String getDescription() {
        return description;
    }
 
    public abstract int getCost();
}
