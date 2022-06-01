package data;

import java.util.stream.Stream;

import model.enums.SongEvent;
import model.models.song.Song;
import model.utils.IRepository;


public class SongMonitoredSaver implements IDataMonitoredSaver<Song, SongEvent> {
	private final IRepository<Song> userRepo;
	
	public SongMonitoredSaver(IRepository<Song> userRepo) {
		this.userRepo = userRepo;

		userRepo.getAll().forEach(this::subscribeToAllEvents);
	}

	@Override
	public void update(SongEvent event) {
		userRepo.save();
	}

	private void subscribeToAllEvents(Song Song) {
		Stream.of(SongEvent.values()).forEach(e -> Song.subscribe(e, this));
	}
}
