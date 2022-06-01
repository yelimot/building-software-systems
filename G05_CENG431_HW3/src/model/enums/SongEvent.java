package model.enums;

import model.models.song.Song;
import model.utils.IEvent;

public enum SongEvent implements IEvent<Song> {
	LIKE,
	REMOVE_LIKE,
	PLAY;
	
	private Song subject;
	
	public SongEvent withSubject(Song subject) {
		this.subject = subject;
		return this;
	}
	
	public boolean hasSubject() {
		return subject != null;
	}
	
	public Song getSubject() {
		return subject;
	}
}
