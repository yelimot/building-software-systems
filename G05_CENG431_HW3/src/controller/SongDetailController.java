package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Session;
import model.enums.SongEvent;
import model.models.playlist.Playlist;
import model.models.song.Song;
import model.models.user.User;
import view.components.SongDetailPanel;

public class SongDetailController implements IController {
	private final SongDetailPanel view;
	private final Song model;
	
	public SongDetailController(SongDetailPanel view, Song model) {
		this.model = model;
		this.view = view;
		
		for (SongEvent event : SongEvent.values()) {
			this.model.subscribe(event, view);
		}
		
		view.addLikeButtonListener(likeButtonListener);
		view.addAddToPlaylistButtonListener(addPlaylistButtonListener);
	}
	
	private ActionListener likeButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		boolean succeed = model.addLike(Session.getUser());
    		if (!succeed) model.removeLike(Session.getUser());
    	}
    };
    
    private ActionListener addPlaylistButtonListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		User user = Session.getUser();
    		
    		Object[] possibilities = user.getCollections().toArray();
    		Playlist result = (Playlist) JOptionPane.showInputDialog(
                view,
                "Please Choose playlist to add",
                "Add to Playlist",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities,
                null
    		);

    		if (result != null) {
    			result.add(model);
    		}

    	}
    };
    
	@Override
	public void destroy() {
		for (SongEvent event : SongEvent.values()) {
			this.model.unsubscribe(event, view);
		}
	}
}