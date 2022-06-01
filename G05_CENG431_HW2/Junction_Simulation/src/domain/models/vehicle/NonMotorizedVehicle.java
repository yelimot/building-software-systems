package domain.models.vehicle;

import controller.IMediator;

public class NonMotorizedVehicle implements IVehicle {
	
	private IMediator mediator;
	private String direction;
	private int roadId;

	public NonMotorizedVehicle(IMediator mediator, String direction) {
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

	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}
	
	public int getRoadId() {
		return this.roadId;
	}

}
