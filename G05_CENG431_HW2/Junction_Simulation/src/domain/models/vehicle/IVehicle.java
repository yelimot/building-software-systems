package domain.models.vehicle;

import controller.IMediator;

public interface IVehicle {
	
	void setDirection(String direction);
	String getDirection();
	void setMediator(IMediator mediator);
	IMediator getMediator();
	void setRoadId(int ID);

}
