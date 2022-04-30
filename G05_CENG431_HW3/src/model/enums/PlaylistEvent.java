package model.enums;

import model.models.playlist.Playlist;
import model.utils.IEvent;

public enum PlaylistEvent implements IEvent<Playlist> {
	ADD_SONG,
	REMOVE_SONG,
	RENAME;
	
	private Playlist subject;
	
	@Override
	public PlaylistEvent withSubject(Playlist subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public Playlist getSubject() {
		return subject;
	}
}

