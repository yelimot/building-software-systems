package controller;

import java.util.List;

import domain.models.road.IRoad;
import domain.models.vehicle.IVehicle;

public interface IMediator {
	
	IVehicle createVehicle();
	IRoad createRoad();
	void startSimulation(List<IVehicle> vehicles, List<IRoad> roads);
	void decideWhichRoadToStore();
	void addVehicleToRoad(IVehicle vehicle);

}