package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.enums.PlaylistEvent;
import model.enums.UserEvent;
import model.models.playlist.Playlist;
import model.models.user.User;
import model.utils.IRepository;
import view.components.ListOfPlaylistsPanel;
import view.components.SongListPanel;
import view.pages.FollowedUsers;

public class FollowedUsersController implements IController {
	private FollowedUsers view;
	private User model;
	private PlaylistListController playlistListController;
	private final IRepository<User> userRepo;
	private Playlist selectedPlaylist;
	private SongListPanel outfitListPanel;
	
	public FollowedUsersController(FollowedUsers view, User model, IRepository<User> userRepo) {
		this.model = model;
		this.view = view;
		this.userRepo = userRepo;
		
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

        			view.setCollectionListPanel(collectionList);
        			view.addCollectionsListSelectionListener(collectionChangeListener);
    			} else {
        			view.setCollectionListPanel(null);
    			}
    		}
    	}
    };
    
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (selectedPlaylist != null) {
        			selectedPlaylist.subscribe(PlaylistEvent.ADD_SONG, outfitListPanel);
        			selectedPlaylist.subscribe(PlaylistEvent.REMOVE_SONG, outfitListPanel);
    			}

				Playlist model = ((JList<Playlist>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				outfitListPanel = new SongListPanel(model);
    				
    				model.subscribe(PlaylistEvent.ADD_SONG, outfitListPanel);
    				model.subscribe(PlaylistEvent.REMOVE_SONG, outfitListPanel);

    				view.setSongListPanel(outfitListPanel);
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
    		
    		List<User> possibilities = userRepo.getAll(u -> !followedUsers.contains(u));
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