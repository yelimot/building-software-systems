package view.pages;

import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import model.models.song.SongRepository;
import view.components.SongDetailPanel;
import view.components.SongRepositoryListPanel;


/**
 * This view shows song list at the left, song details at the right.
 * 
 * Behaviour:
 * - When user selected song from the list, song details will show up on the right.
 *   User can like, remove like.
 * 
 * Children:
 * 	- SongRepositoryListPanel
 *	- SongDetailPanel
 */
public class HomePanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	private SongRepositoryListPanel songList;
	private SongDetailPanel songDetail;
	
	public HomePanel(SongRepository model) {
        setSize(960, 685);
        setLayout(null);
        setVisible(true);
        
		songList = new SongRepositoryListPanel(model);
        songList.setBounds(5, 20, 340, 665);
        add(songList);
    }
	
	public void setSongDetailPanel(SongDetailPanel songDetail) {
		if (this.songDetail != null) remove(this.songDetail);
		
		if (songDetail != null) {
			this.songDetail = songDetail;
			this.songDetail.setBounds(520, 0, 440, 685);
	        add(this.songDetail);
		}

		repaint();
		revalidate();
	}
	
	public void addListSelectionListener(ListSelectionListener playlistChangeListener) {
        songList.addListSelectionListener(playlistChangeListener);
	}

	public void addLikeButtonListener(ActionListener listener) {
		songDetail.addLikeButtonListener(listener);
	}
}
