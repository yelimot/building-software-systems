package data.monitor;

import java.util.List;

import model.enums.SongEvent;
import model.models.song.Song;
import model.utils.IRepository;

/**
 * Monitors all songs to find most liked song
 */
public class MostLikedSongMonitor implements IMonitor<Song, SongEvent> {
	private Song mostLiked;
	
	public MostLikedSongMonitor(IRepository<Song> songRepo) {
		List<Song> songs = songRepo.getAll();
		
		songs.forEach(o -> {
			subscribeTo(o);
			if (hasMoreLike(o)) mostLiked = o;
		});
	}

	@Override
	public void update(SongEvent event) {
		if (hasMoreLike(event.getSubject())) mostLiked = event.getSubject();
	}

	@Override
	public Song get() {
		return mostLiked;
	}

	private void subscribeTo(Song song) {
		song.subscribe(SongEvent.LIKE, this);
		song.subscribe(SongEvent.REMOVE_LIKE, this);
	}
	
	private boolean hasMoreLike(Song song) {
		return mostLiked == null || song.getNumberOfLikes() > mostLiked.getNumberOfLikes();
	}
}
