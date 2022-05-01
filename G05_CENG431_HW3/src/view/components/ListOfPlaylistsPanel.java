package view.components;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;

import model.enums.UserEvent;
import model.models.user.User;
import model.utils.IObserver;

/**
 * Shoes all collections of user.
 */
public class ListOfPlaylistsPanel extends JPanel implements IObserver<User, UserEvent> {
	private static final long serialVersionUID = -669293105768399715L;
	private JScrollPane usersScroller;
	private JList<Object> playlists;
	private User model;
	
	public ListOfPlaylistsPanel(User model) {
		this.model = model;
		
        setSize(300, 540);
        setLayout(null);
        setVisible(true);
                
        usersScroller = new JScrollPane();
        usersScroller.setBounds(0, 30, 300, 510);
        usersScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        usersScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(usersScroller);

        playlists = new JList<Object>(model.getPlaylists().toArray());
        playlists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlists.setVisibleRowCount(-1);
        
        usersScroller.setViewportView(playlists);
        
        JLabel usersTitle = new JLabel("Playlists");
        usersTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        usersTitle.setBounds(0, 0, 140, 15);
        add(usersTitle);

	}
	
	public void addListSelectionListener(ListSelectionListener playlistChangeListener) {
		playlists.addListSelectionListener(playlistChangeListener);
		playlists.setSelectedIndex(0);
	}
	
	@Override
	public void update(UserEvent event) {
		switch (event) {
			case ADD_PLAYLIST:
			case REMOVE_PLAYLIST:
				playlists.removeAll();
				playlists.setListData(model.getPlaylists().toArray());
			default:
				break;
		}		
	}
}
