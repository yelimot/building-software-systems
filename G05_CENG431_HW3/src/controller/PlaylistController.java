package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.models.playlist.Playlist;
import model.models.user.User;
import view.components.ListOfPlaylistsPanel;
import view.pages.PlaylistsPanel;


public class PlaylistController implements IController {
	private PlaylistsPanel view;
	private User model;
	private PlaylistListController playlistListController;
	private ListOfPlaylistsPanel songListPanel;
	private Playlist selectedPlaylist;
	
	public PlaylistController(PlaylistsPanel view, User model) {
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
			String name = view.getNewOutfitCollectionName();
			if (StringUtils.isValid(name)) model.addCollection(new OutfitCollection(name));
		}
	};
	
	private ActionListener removeItemButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Outfit selected = outfitListPanel.getSelection();
			if (selected != null) {
				selectedCollection.remove(selected);
			}
		}
	};
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
		@SuppressWarnings("unchecked")
    	public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (selectedCollection != null) {
        			selectedCollection.unsubscribe(OutfitCollectionEvent.ADD_OUTFIT, outfitListPanel);
        			selectedCollection.unsubscribe(OutfitCollectionEvent.REMOVE_OUTFIT, outfitListPanel);	
    			}

				OutfitCollection model = ((JList<OutfitCollection>)event.getSource()).getSelectedValue();    		
				
    			if (model != null) {
    				outfitListPanel = new OutfitCollectionListPanel(model);
    				
    				model.subscribe(OutfitCollectionEvent.ADD_OUTFIT, outfitListPanel);
    				model.subscribe(OutfitCollectionEvent.REMOVE_OUTFIT, outfitListPanel);

    				view.setOutfitListPanel(outfitListPanel);
    				view.setVisibilityOfRemoveButton(true);
    			} else {
    				view.setOutfitListPanel(null);
    				view.setVisibilityOfRemoveButton(false);
    			}
				
				selectedCollection = model;
			}
    	}
    };

	@Override
	public void destroy() {
		collectionListController.destroy();
	}
}
