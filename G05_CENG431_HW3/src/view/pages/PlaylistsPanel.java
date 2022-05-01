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
 * Shows current user's collections and its content.
 * 
 * Behaviour:
 * - Users selects collection from left.
 * - Song list shows up at right.
 * - User removes song by selecting it and clicking remove button.
 * - User creates collection by writing its name to input in lower 
 * 	left and clicking Create button.
 * 
 * Children:
 * - CollectionListPanel
 * - PlaylistListPanel
 */
public class PlaylistsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	private JTextField collectionNameField;
	private ListOfPlaylistsPanel collectionsList;
	private PlaylistPanel playlist;
	private JButton createCollectionButton;
	private JButton removeItemButton;

	public PlaylistsPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        collectionsList = new ListOfPlaylistsPanel(model);
        collectionsList.setBounds(20, 20, 420, 540);
        add(collectionsList);
		
        collectionNameField = new JTextField();
        collectionNameField.setBounds(20, 570, 300, 30);
        collectionNameField.setColumns(10);
        add(collectionNameField);
		
        createCollectionButton = new JButton("Create");
        createCollectionButton.setBounds(215, 610, 105, 25);
        add(createCollectionButton);
              
        removeItemButton = new JButton("Remove Item From Collection");
        removeItemButton.setBounds(560, 580, 300, 30);
        add(removeItemButton);
	}
	
	public ListOfPlaylistsPanel getCollectionListPanel() {
		return collectionsList;
	}
	
	public String getNewPlaylistName() {
		return collectionNameField.getText();
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
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
		collectionsList.addListSelectionListener(collectionChangeListener);
	}
	
	public void addCreateButtonListener(ActionListener createButtonListener) {
		createCollectionButton.addActionListener(createButtonListener);
	}
	
	public void addRemoveItemButtonListener(ActionListener removeItemButtonListener) {
		removeItemButton.addActionListener(removeItemButtonListener);
	}
}
