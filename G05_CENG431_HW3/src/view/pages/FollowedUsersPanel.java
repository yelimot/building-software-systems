package view.pages;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import model.models.user.User;
import view.components.FollowedUsersListPanel;
import view.components.ListOfPlaylistsPanel;
import view.components.SongListPanel;

/**
 * Shows user's followed users, their playlists and items in these playlists.
 * 
 * Behaviour:
 * - The user select followed user.
 * - The followed user's playlists show up at center.
 * - The user selects playlist.
 * - The songs of selected playlist show up at right.
 * - The user follows/unfollows users from lower left.
 * 
 * Children:
 * - FollowedUsersListPanel
 * - ListOfPlaylistsPanel
 * - SongListPanel
 */
public class FollowedUsersPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	private FollowedUsersListPanel userList;
	private JButton followButton;
	private ListOfPlaylistsPanel playlistList;
	private SongListPanel<?,?> songList;
	private JButton unfollowButton;
	
	public FollowedUsersPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        userList = new FollowedUsersListPanel(model);
        userList.setBounds(10, 20, 300, 540);
        add(userList);
		
        followButton = new JButton("Follow New");
        followButton.setBounds(10, 570, 140, 30);
        add(followButton);
		
        unfollowButton = new JButton("Unfollow");
        unfollowButton.setBounds(170, 570, 140, 30);
        add(unfollowButton);

	}
	
	public FollowedUsersListPanel getUserListPanel() {
		return userList;
	}
	
	public void addUserListSelectionListener(ListSelectionListener playlistChangeListener) {
        userList.addListSelectionListener(playlistChangeListener);
	}
	
	public void addFollowButtonListener(ActionListener followButtonActionListener) {
		followButton.addActionListener(followButtonActionListener);
	}
	
	public void addUnfollowButtonListener(ActionListener unfollowButtonActionListener) {
		unfollowButton.addActionListener(unfollowButtonActionListener);
	}
	
	public void addPlaylistsListSelectionListener(ListSelectionListener playlistChangeListener) {
		playlistList.addListSelectionListener(playlistChangeListener);
	}

	public void setPlaylistListPanel(ListOfPlaylistsPanel playlistList) {
		if (this.playlistList != null) remove(this.playlistList);
		
		if (playlistList != null) {
			this.playlistList = playlistList;
			this.playlistList.setBounds(330, 20, 300, 540);;
	        add(this.playlistList);
		}

		repaint();
		revalidate();		
	}
	
	public void setSongListPanel(SongListPanel<?,?> songList) {
		if (this.songList != null) remove(this.songList);
		
		if (songList != null) {
			this.songList = songList;
			this.songList.setBounds(650, 20, 300, 540);
	        add(this.songList);
		}

		repaint();
		revalidate();		
	}
}
