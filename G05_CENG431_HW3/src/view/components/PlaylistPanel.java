package view.components;

import model.models.playlist.Playlist;
import model.models.playlist.PlaylistEvent;
import model.models.song.AbstractSongContainer;

/**
 * Shows all songs of collection in list.
 * 
 * Behaviour:
 * - updated when song added/removed.
 */
public class PlaylistPanel extends SongListPanel<Playlist, PlaylistEvent> {
	private static final long serialVersionUID = -9135208168535913299L;

	public PlaylistPanel(AbstractSongContainer<Playlist, PlaylistEvent> model) {
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
