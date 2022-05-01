package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.models.playlist.Playlist;
import model.models.playlist.PlaylistEvent;
import model.models.song.Song;
import model.models.user.User;
import model.utils.StringUtils;
import view.components.PlaylistPanel;
import view.pages.PlaylistsPanel;


public class PlaylistsController implements IController {
	private PlaylistsPanel view;
	private User model;
	private PlaylistListController playlistListController;
	private PlaylistPanel playlistPanel;
	private Playlist selectedPlaylist;
	
	public PlaylistsController(PlaylistsPanel view, User model) {
		this.model = model;
		this.view = view;
		
		this.playlistListController = new PlaylistListController(view.getCollectionListPanel(), model);
		
		this.view.addListSelectionListener(collectionChangeListener);
		this.view.addRemoveItemButtonListener(removeItemButtonListener);

		view.addCreateButtonListener(createButtonListener);
	}
	
	private ActionListener createButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String name = view.getNewPlaylistName();
			if (StringUtils.isValid(name)) model.addCollection(new Playlist(name));
		}
	};
	
	private ActionListener removeItemButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Song selected = playlistPanel.getSelection();
			if (selected != null) {
				selectedPlaylist.remove(selected);
			}
		}
	};
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (selectedPlaylist != null) {
        			selectedPlaylist.unsubscribe(PlaylistEvent.ADD_SONG, playlistPanel);
        			selectedPlaylist.unsubscribe(PlaylistEvent.REMOVE_SONG, playlistPanel);	
    			}

				Playlist model = ((JList<Playlist>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				playlistPanel = new PlaylistPanel(model);
    				
    				model.subscribe(PlaylistEvent.ADD_SONG, playlistPanel);
    				model.subscribe(PlaylistEvent.REMOVE_SONG, playlistPanel);

    				view.setSongListPanel(playlistPanel);
    				view.setVisibilityOfRemoveButton(true);
    			} else {
    				view.setSongListPanel(null);
    				view.setVisibilityOfRemoveButton(false);
    			}
				
				selectedPlaylist = model;
			}
    	}
    };

	@Override
	public void destroy() {
		playlistListController.destroy();
	}
}
