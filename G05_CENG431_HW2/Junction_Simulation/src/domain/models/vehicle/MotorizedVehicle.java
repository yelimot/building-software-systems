package domain.models.vehicle;

import controller.IMediator;

public class MotorizedVehicle implements IVehicle {
	
	private IMediator mediator;
	private String direction;

	public MotorizedVehicle(IMediator mediator, String direction) {
		super();
		this.mediator = mediator;
		this.direction = direction;
	}

	@Override
	public void setDirection(String direction) {
		// TODO Auto-generated method stub
		this.direction = direction;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return this.direction;
	}

	@Override
	public void setMediator(IMediator mediator) {
		// TODO Auto-generated method stub
		this.mediator = mediator;
	}

	@Override
	public IMediator getMediator() {
		// TODO Auto-generated method stub
		return this.mediator;
	}

	@Override
	public void setRoadId(int roadId) {
		// TODO Auto-generated method stub
		
	}

}
