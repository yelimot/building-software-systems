package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.enums.UserEvent;
import model.models.playlist.Playlist;
import model.models.playlist.PlaylistEvent;
import model.models.user.User;
import model.utils.IRepository;
import view.components.ListOfPlaylistsPanel;
import view.components.PlaylistPanel;
import view.pages.FollowedUsersPanel;

public class FollowedUsersController implements IController {
	private FollowedUsersPanel view;
	private User model;
	private PlaylistListController playlistListController;
	private final IRepository<User> userRepository;
	private Playlist selectedPlaylist;
	private PlaylistPanel playlistPanel;
	
	public FollowedUsersController(FollowedUsersPanel view, User model, IRepository<User> userRepository) {
		this.model = model;
		this.view = view;
		this.userRepository = userRepository;
		
		this.view.addUserListSelectionListener(userListChangeListener);
		this.view.addFollowButtonListener(followButtonActionListener);
		this.view.addUnfollowButtonListener(unfollowButtonActionListener);
		
		this.model.subscribe(UserEvent.FOLLOW, view.getUserListPanel());
		this.model.subscribe(UserEvent.UNFOLLOW, view.getUserListPanel());
	}
	
	@Override
	public void destroy() {
		if (playlistListController != null) playlistListController.destroy();
		
		this.model.unsubscribe(UserEvent.FOLLOW, view.getUserListPanel());
		this.model.unsubscribe(UserEvent.UNFOLLOW, view.getUserListPanel());
	}
	
	private ListSelectionListener userListChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (playlistListController != null) playlistListController.destroy();
    			
    			User model = ((JList<User>)event.getSource()).getSelectedValue();
    			
    			view.setSongListPanel(null);

    			if (model != null) {
    				ListOfPlaylistsPanel collectionList = new ListOfPlaylistsPanel(model);
    				playlistListController = new PlaylistListController(collectionList, model);

        			view.setPlaylistListPanel(collectionList);
        			view.addPlaylistsListSelectionListener(collectionChangeListener);
    			} else {
        			view.setPlaylistListPanel(null);
    			}
    		}
    	}
    };
    
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (selectedPlaylist != null) {
        			selectedPlaylist.subscribe(PlaylistEvent.ADD_SONG, playlistPanel);
        			selectedPlaylist.subscribe(PlaylistEvent.REMOVE_SONG, playlistPanel);
    			}

				Playlist model = ((JList<Playlist>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				playlistPanel = new PlaylistPanel(model);
    				
    				model.subscribe(PlaylistEvent.ADD_SONG, playlistPanel);
    				model.subscribe(PlaylistEvent.REMOVE_SONG, playlistPanel);

    				view.setSongListPanel(playlistPanel);
    			} else {
    				view.setSongListPanel(null);
    			}
				
				selectedPlaylist = model;
			}
    	}
    };

    private ActionListener followButtonActionListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		List<User> followedUsers = model.getFollowedUsers();
    		
    		List<User> possibilities = userRepository.getAll(u -> !followedUsers.contains(u));
    		possibilities.remove(model);
    		
    		User result = (User) JOptionPane.showInputDialog(
    			view,
                "Please choose user to follow",
                "Follow new User",
                JOptionPane.PLAIN_MESSAGE,
                null,
                possibilities.toArray(),
                null);
    		
    		if (result != null) {
    			model.follow(result);
    		}
    	}
    };
    
    private ActionListener unfollowButtonActionListener = new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		User subject = view.getUserListPanel().getSelectedValue();
    		model.unfollow(subject);
    	}
    };
}