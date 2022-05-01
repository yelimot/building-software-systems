package controller;

import model.enums.UserEvent;
import model.models.user.User;
import view.components.ListOfPlaylistsPanel;

public class PlaylistListController implements IController {
	private final ListOfPlaylistsPanel view;
	private final User model;
	
	public PlaylistListController(ListOfPlaylistsPanel view, User model) {
		this.model = model;
		this.view = view;
		
		this.model.subscribe(UserEvent.ADD_PLAYLIST, view);
		this.model.subscribe(UserEvent.REMOVE_PLAYLIST, view);
	}
    
	@Override
	public void destroy() {
		this.model.unsubscribe(UserEvent.ADD_PLAYLIST, view);
		this.model.unsubscribe(UserEvent.REMOVE_PLAYLIST, view);
	}
}
