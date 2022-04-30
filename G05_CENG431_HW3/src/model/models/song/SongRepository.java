package model.models.song;

import data.IDataLoader;
import data.IDataSaver;
import model.enums.SongRepositoryEvent;

public class SongRepository extends AbstractSongContainer<SongRepository, SongRepositoryEvent> {
	private final IDataSaver<Song> dataSaver;
	
	public SongRepository(IDataLoader<Song> dataLoader, IDataSaver<Song> dataSaver) {
		super();
		dataLoader.load().forEach(this::add);
		this.dataSaver = dataSaver;
	}

	@Override
	public void save() {
		dataSaver.save(getAll());		
	}
}
