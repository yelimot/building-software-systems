package model.enums;

import model.models.user.UserRepository;
import model.utils.IEvent;

public enum UserRepositoryEvent implements IEvent<UserRepository> {
	ADDED,
	REMOVED;

	private UserRepository subject;
	
	@Override
	public UserRepositoryEvent withSubject(UserRepository subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public UserRepository getSubject() {
		return subject;
	}
}
