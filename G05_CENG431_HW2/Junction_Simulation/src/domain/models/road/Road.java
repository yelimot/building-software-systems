package domain.models.road;

import controller.IMediator;

public class Road implements IRoad {
	
	private IMediator mediator;

	public Road(IMediator mediator) {
		super();
		this.mediator = mediator;
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

}
