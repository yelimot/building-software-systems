package model.models.song;

import java.util.HashSet;
import java.util.Set;

import model.enums.Genre;
import model.enums.SongEvent;
import model.models.user.User;
import model.utils.AbstractObservable;

public class Song extends AbstractObservable<Song, SongEvent> implements Comparable<Song> {
	private final Genre genre;
	private final int id;
	private final String songName;
	private final String artistName;
	private final int duration;
	private final int popularity;
	private final int numberOfLikes;
	private final Set<String> likedUserIds;
	
	public Song(Genre genre, int id, String songName, String artistName, int duration, int popularity, int numberOfLikes) {
		this.genre = genre;
		this.id = id;
		this.songName = songName;
		this.artistName = artistName;
		this.duration = duration;
		this.popularity = popularity;
		this.numberOfLikes = numberOfLikes;
		this.likedUserIds = new HashSet<>();
	}
	
	
	public Genre getGenre() {
		return genre;
	}


	public int getId() {
		return id;
	}


	public String getSongName() {
		return songName;
	}


	public String getArtistName() {
		return artistName;
	}


	public int getDuration() {
		return duration;
	}


	public int getPopularity() {
		return popularity;
	}


	public int getNumberOfLikes() {
		return numberOfLikes;
	}


	public Set<String> getLikedUserIds() {
		return likedUserIds;
	}
	
	public int getLikeCount() {
		return likedUserIds.size();
	}
	
	public boolean addLike(String userId) {
		boolean result = likedUserIds.add(userId);
		if (result) notifySubscribers(SongEvent.LIKE.withSubject(this));
		
		return result;
	}
	
	public boolean addLike(User user) {
		return addLike(user.getUsername());
	}
	
	public boolean removeLike(User user) {
		boolean result = likedUserIds.remove(user.getUsername());
		if (result) notifySubscribers(SongEvent.REMOVE_LIKE.withSubject(this));
		return result;
	}
	
	// TODO
	public boolean playSong(int songId) {
		// To-Do playSong
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("<html>%s by <i>%s</i> (#%d)</html>", songName, artistName, id);
	}

	@Override
	public int compareTo(Song o) {
		return getId() - o.getId();
	}
}