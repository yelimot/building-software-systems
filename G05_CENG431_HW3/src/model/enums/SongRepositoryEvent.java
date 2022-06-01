package model.enums;


import model.models.song.SongRepository;
import model.utils.IEvent;

public enum SongRepositoryEvent implements IEvent<SongRepository> {
	ADD_SONG,
	REMOVE_SONG;
	
	private SongRepository subject;
	
	@Override
	public SongRepositoryEvent withSubject(SongRepository subject) {
		this.subject = subject;
		return this;
	}

	@Override
	public boolean hasSubject() {
		return subject != null;
	}

	@Override
	public SongRepository getSubject() {
		return subject;
	}
}