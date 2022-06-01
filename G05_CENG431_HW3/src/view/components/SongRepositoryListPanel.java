package view.components;

import model.enums.SongRepositoryEvent;
import model.models.song.AbstractSongContainer;
import model.models.song.SongRepository;

/**
 * Shows all songs in list.
 * 
 * Behaviour:
 * - updated when song added/removed.
 */
public class SongRepositoryListPanel extends SongListPanel<SongRepository, SongRepositoryEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public SongRepositoryListPanel(AbstractSongContainer<SongRepository, SongRepositoryEvent> model) {
		super(model);
	}

	public void update(SongRepositoryEvent event) {
		switch(event) {
			case ADD_SONG:
			case REMOVE_SONG:
				songs.removeAll();
				songs.setListData(model.getAll().toArray());
			default:
				break;
		}
	}
}
