package view.pages;

import javax.swing.JPanel;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

import view.components.ListOfPlaylistsPanel;

/**
 * Shows current user's playlists and its content.
 * 
 * Behaviour:
 * - Users selects playlist from left.
 * - Song list shows up at right.
 * - User removes song by selecting it and clicking remove button.
 * - User creates playlist by writing its name to input and clicking create button.
 * 
 * Children:
 * - PlaylistListPanel
 * - OutfitCollectionListPanel
 */
public class CollectionsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	private JTextField collectionNameField;
	private ListOfPlaylistsPanel playlistsList;
	private OutfitCollectionListPanel outfitList;
	private JButton createCollectionButton;
	private JButton removeItemButton;

	public CollectionsPanel(User model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
        collectionsList = new CollectionListPanel(model);
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
	
	public CollectionListPanel getCollectionListPanel() {
		return collectionsList;
	}
	
	public String getNewOutfitCollectionName() {
		return collectionNameField.getText();
	}

	public void setOutfitListPanel(OutfitCollectionListPanel outfitList) {
		if (this.outfitList != null) remove(this.outfitList);

		if (outfitList != null){
			this.outfitList = outfitList;
			this.outfitList.setBounds(560, 20, 300, 540);
	        add(this.outfitList);
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
