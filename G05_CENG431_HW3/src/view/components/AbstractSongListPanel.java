package view.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import model.models.song.AbstractSongContainer;
import model.models.song.Song;
import model.utils.IEvent;
import model.utils.IObserver;

/**
 * Generic song list panel for both song collection and song repository.
 *
 * @param <T> model
 * @param <K> model event
 */
public abstract class AbstractSongListPanel<T, K extends IEvent<T>> extends JPanel implements IObserver<T, K> {
	private static final long serialVersionUID = -669290185768399715L;
	
	protected JScrollPane songsScroller;
	protected JList<Object> songs;
	protected model.models.song.AbstractSongContainer<T, K> model;
	
	public AbstractSongListPanel(AbstractSongContainer<T, K> model) {
		this.model = model;
		
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
                       
        songsScroller = new JScrollPane();
        songsScroller.setBounds(0, 30, 300, 510);
        songsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        songsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(songsScroller);

        songs = new JList<Object>(model.getAll().toArray());
        songs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        songs.setVisibleRowCount(-1);
        
        songsScroller.setViewportView(songs);
        
        JLabel songsTitle = new JLabel("Songs");
        songsTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        songsTitle.setBounds(0, 0, 140, 15);
        add(songsTitle);
	}

	public Song getSelection() {
		return (Song) songs.getSelectedValue();
	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        songs.addListSelectionListener(collectionChangeListener);
        songs.setSelectedIndex(0);
	}
}
