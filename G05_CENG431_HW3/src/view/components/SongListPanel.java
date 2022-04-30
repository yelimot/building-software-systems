package view.components;

import model.enums.PlaylistEvent;
import model.models.playlist.Playlist;
import model.models.song.AbstractSongContainer;

/**
 * Shows all songs of playlist in list.
 * 
 * Behavior:
 * - updated when song added/removed.
 */
public class SongListPanel extends AbstractSongListPanel<Playlist, PlaylistEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public SongListPanel(AbstractSongContainer<Playlist, PlaylistEvent> model) {
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