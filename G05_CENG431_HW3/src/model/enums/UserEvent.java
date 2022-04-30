package model.enums;

import model.models.user.User;
import model.utils.IEvent;

public enum UserEvent implements IEvent<User> {
	FOLLOW,
	UNFOLLOW,
	FOLLOWED,
	UNFOLLOWED,
	ADD_COLLECTION,
	REMOVE_COLLECTION,;
	
	private User subject;
	
	@Override
	public UserEvent withSubject(User subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public User getSubject() {
		return subject;
	}
	
}
