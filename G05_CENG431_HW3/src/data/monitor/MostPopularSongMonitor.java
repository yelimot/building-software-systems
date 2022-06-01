package data.monitor;

import java.util.List;

import model.enums.SongEvent;
import model.models.song.Song;
import model.utils.IRepository;



/**
 * Monitors all songs to find most popular song
 */
public class MostPopularSongMonitor implements IMonitor<Song, SongEvent> {
	private Song mostPopular;
	
	public MostPopularSongMonitor(IRepository<Song> songRepo) {
		List<Song> songs = songRepo.getAll();
		
		songs.forEach(o -> {
			subscribeTo(o);
			if (isMorePopular(o)) mostPopular = o;
		});
	}

	@Override
	public void update(SongEvent event) {
		if (isMorePopular(event.getSubject())) mostPopular = event.getSubject();
	}

	@Override
	public Song get() {
		return mostPopular;
	}

	private void subscribeTo(Song song) {
		song.subscribe(SongEvent.PLAY, this);
	}
	
	private boolean isMorePopular(Song song) {
		return mostPopular == null || song.getPopularity() > mostPopular.getPopularity();
	}
}
