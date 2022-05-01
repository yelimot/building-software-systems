package view.pages;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import model.models.user.User;
import view.components.ListOfPlaylistsPanel;
import view.components.PlaylistPanel;

/**
 * Shows current user's playlists and its content.
 * 
 * Behaviour:
 * - Users selects playlist from left.
 * - Song list shows up at right.
 * - User removes song by selecting it and clicking remove button.
 * - User creates playlist by writing its name to input in lower 
 * 	left and clicking Create button.
 * 
 * Children:
 * - ListOfPlaylistsPanel
 * - PlaylistPanel
 */
public class PlaylistsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	private JTextField playlistNameField;
	private ListOfPlaylistsPanel playlistsList;
	private PlaylistPanel playlist;
	private JButton createPlaylistButton;
	private JButton removeItemButton;

	public PlaylistsPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        playlistsList = new ListOfPlaylistsPanel(model);
        playlistsList.setBounds(20, 20, 420, 540);
        add(playlistsList);
		
        playlistNameField = new JTextField();
        playlistNameField.setBounds(20, 570, 300, 30);
        playlistNameField.setColumns(10);
        add(playlistNameField);
		
        createPlaylistButton = new JButton("Create");
        createPlaylistButton.setBounds(215, 610, 105, 25);
        add(createPlaylistButton);
              
        removeItemButton = new JButton("Remove Item From Playlist");
        removeItemButton.setBounds(560, 580, 300, 30);
        add(removeItemButton);
	}
	
	public ListOfPlaylistsPanel getPlaylistListPanel() {
		return playlistsList;
	}
	
	public String getNewPlaylistName() {
		return playlistNameField.getText();
	}

	public void setSongListPanel(PlaylistPanel playlist) {
		if (this.playlist != null) remove(this.playlist);

		if (playlist != null){
			this.playlist = playlist;
			this.playlist.setBounds(560, 20, 300, 540);
	        add(this.playlist);
		}
		
		repaint();
		revalidate();
	}
	
	public void setVisibilityOfRemoveButton(boolean visible) {
		removeItemButton.setVisible(visible);
	}
	
	public void addListSelectionListener(ListSelectionListener playlistChangeListener) {
		playlistsList.addListSelectionListener(playlistChangeListener);
	}
	
	public void addCreateButtonListener(ActionListener createButtonListener) {
		createPlaylistButton.addActionListener(createButtonListener);
	}
	
	public void addRemoveItemButtonListener(ActionListener removeItemButtonListener) {
		removeItemButton.addActionListener(removeItemButtonListener);
	}
}
