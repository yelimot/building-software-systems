package domain.rules;

import java.util.List;

import domain.models.vehicle.IVehicle;

public interface IRules {
	
	/*
	 * 1 - This rule checks whether are there any 
	 *     non-motorised vehicles in the list exist 
	 *     with motorised vehicles (In this case all
	 *     non motorised vehicles eliminated from the 
	 *     list). If all the elements in the list are
	 *     non-motorised, nothing will happen. 
	 */
	public void Rule1(List<IVehicle> vehicles);
	
	/*
	 * 2 - This rule checks whether are there any 
	 *     tractor or engineering vehicles exist in the list  
	 *     with other motorised vehicles (In this case all
	 *     these vehicles eliminated from the 
	 *     list). If all the elements in the list are
	 *     tractor or engineering vehicles, nothing will happen. 
	 */
	public void Rule2(List<IVehicle> vehicles);
	
	/*
	 * 3 - This rule checks road IDs of the vehicles 
	 *     the bigger roadID element will be eliminated 
	 *     (Vehicles should give way to traffic approaching 
	 *     from the right (For example: a car on the 3rd 
	 *     road should give way to a car on the 2nd road).).
	 */
	public void Rule3(List<IVehicle> vehicles);
	
	/*
	 * 4 - This rule checks where to turn the vehicles. Vehicles 
	 *     that they will turn left will be eliminated. However, 
	 *     if all cars will turn left, the Rule3 will called.
	 */
	public void Rule4(List<IVehicle> vehicles);
	
	/*
	 * 5 - If are there any pedestrian exist (In the mediator class),  
	 * 	   the simulation will wait 2 rounds.
	 */
	public void Rule5(List<IVehicle> vehicles);
	
	/*
	 * 6 - After calling all the prior rules, if there exist 3 or 4
	 *     vehicles (and a car on the road 1) in the list, give the 
	 *     right-of-way to the vehicle on the 1st road.
	 */
	public void Rule6(List<IVehicle> vehicles);
	
	/*
	 * 7 - After calling all the prior rules, if there exist 3 or 4
	 *     vehicles (and a car on the road 1) in the list, give the 
	 *     right-of-way to the vehicle on the 1st road.
	 */
	public void Rule7(List<IVehicle> vehicles);
	
	/*
	 * 8 - After calling all the prior rules, if there exist 2
	 *     vehicles (and a car on the road 1) in the list, give the 
	 *     right-of-way to the vehicle on the smallerID road.
	 */
	public void Rule8(List<IVehicle> vehicles);

}
