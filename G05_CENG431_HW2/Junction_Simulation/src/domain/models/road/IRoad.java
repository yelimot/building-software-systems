package domain.models.road;

import controller.IMediator;

public interface IRoad {

	void setMediator(IMediator mediator);
	IMediator getMediator();
}
