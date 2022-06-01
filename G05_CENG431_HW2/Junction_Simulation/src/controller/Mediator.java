package controller;

import java.util.List;

import domain.models.road.IRoad;
import domain.models.vehicle.IVehicle;

public class Mediator implements IMediator {
	
	List<IVehicle> vehicles;
	List<IRoad> roads;
	boolean pedestrian; // or class?

	@Override
	public IVehicle createVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Mediator(List<IVehicle> vehicles, List<IRoad> roads) {
		super();
		this.vehicles = vehicles;
		this.roads = roads;
	}

	public boolean isPedestrian() {
		return pedestrian;
	}

	public void setPedestrian(boolean pedestrian) {
		this.pedestrian = pedestrian;
	}

	@Override
	public IRoad createRoad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void decideWhichRoadToStore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVehicleToRoad(IVehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startSimulation(List<IVehicle> vehicles, List<domain.models.road.IRoad> roads) {
		// TODO Auto-generated method stub
		
	}
}