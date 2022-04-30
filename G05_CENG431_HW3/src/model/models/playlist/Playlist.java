package model.models.playlist;

import model.models.song.AbstractSongContainer;
import model.models.song.Song;

public class Playlist extends AbstractSongContainer<Playlist, PlaylistEvent> implements Comparable<Playlist> {
	private String name;

	public Playlist(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifySubscribers(PlaylistEvent.RENAME.withSubject(this));
	}
	
	public boolean add(Song song) {
		boolean result = super.add(song);
		if (result) notifySubscribers(PlaylistEvent.ADD_SONG.withSubject(this));
		return result;
	}
	
	public boolean remove(Song song) {
		boolean result = super.remove(song);
		if (result) notifySubscribers(PlaylistEvent.REMOVE_SONG.withSubject(this));
		return result;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Playlist arg0) {
		return getName().compareTo(arg0.getName());
	}

	@Override
	public void save() {
	}
}
