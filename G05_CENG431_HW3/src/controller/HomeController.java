package controller;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.models.song.Song;
import model.models.song.SongRepository;
import view.components.SongDetailPanel;
import view.pages.HomePanel;

public class HomeController implements IController {
	private final HomePanel view;
	private SongDetailController songDetailController;
	
	public HomeController(HomePanel view, SongRepository model) {
		this.view = view;
		
		this.view.addListSelectionListener(collectionChangeListener);
	}
	
	private ListSelectionListener collectionChangeListener = new ListSelectionListener() {
    	@SuppressWarnings("unchecked")
		public void valueChanged(ListSelectionEvent event) {
    		if (!event.getValueIsAdjusting()) {
    			if (songDetailController != null) songDetailController.destroy();
    			
    			JList<Song> source = (JList<Song>)event.getSource();
    			Song model = source.getSelectedValue();
    			
    			if (model != null) {
        			SongDetailPanel songDetail = new SongDetailPanel(view, model);
        			songDetailController = new SongDetailController(songDetail, model);
        			view.setSongDetailPanel(songDetail);
    			} else {
        			view.setSongDetailPanel(null);
    			}
    		}
    	}
    };
	
	@Override
	public void destroy() {
		if (songDetailController != null) songDetailController.destroy();
	}

}
