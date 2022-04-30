package view.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;

import model.enums.UserEvent;
import model.models.user.User;
import model.utils.IObserver;

/**
 * Shows playlist's of user.
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

        playlists = new JList<Object>(model.getCollections().toArray());
        playlists.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        playlists.setVisibleRowCount(-1);
        
        usersScroller.setViewportView(playlists);
        
        JLabel usersTitle = new JLabel("Collections");
        usersTitle.setFont(new Font("Dialog", Font.BOLD, 18));
        usersTitle.setBounds(0, 0, 140, 15);
        add(usersTitle);

	}
	
	public void addListSelectionListener(ListSelectionListener collectionChangeListener) {
        playlists.addListSelectionListener(collectionChangeListener);
        playlists.setSelectedIndex(0);
	}
	
	@Override
	public void update(UserEvent event) {
		switch (event) {
			case ADD_COLLECTION:
			case REMOVE_COLLECTION:
				playlists.removeAll();
				playlists.setListData(model.getCollections().toArray());
			default:
				break;
		}		
	}
}

