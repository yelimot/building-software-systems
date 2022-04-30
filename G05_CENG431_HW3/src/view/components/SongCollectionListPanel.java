package view.components;

import model.enums.SongCollection;
import model.enums.PlaylistEvent;
import model.models.song.AbstractSongContainer;

/**
 * Shows all songs of collection in list.
 * 
 * Behaviour:
 * - updated when song added/removed.
 */
public class SongCollectionListPanel extends AbstractSongListPanel<SongCollection, PlaylistEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public SongCollectionListPanel(AbstractSongContainer<SongCollection, PlaylistEvent> model) {
		super(model);
	}

	public void update(PlaylistEvent event) {
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
