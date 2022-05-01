package view.components;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;

import model.enums.SongEvent;
import model.models.song.Song;
import model.utils.IObserver;

/**
 * Shows all details of song. 
 * Shows like/play buttons.
 * 
 * Subscribes its details to keep itself updated.
 */
public class SongDetailPanel extends JPanel implements IObserver<Song, SongEvent> {
	private static final long serialVersionUID = -669290185768399715L;
	private Song model;
	private JLabel genreIdLabel;
	private JLabel trackIdLabel;
	private JLabel songNameLabel;
	private JLabel artistNameLabel;
	private JLabel durationLabel;
	private JLabel popularityLabel;
	private JLabel likeCountLabel;
	private JButton sendButton;
	private JButton likeButton; 
	private JButton addCollectionButton;
	private JButton playButton;
	private JList<Object> comments;
	
	public SongDetailPanel(JPanel parent, Song model) {
		this.model = model;
        setSize(420, 685);
        setLayout(null);
        setVisible(true);
                        
        JScrollPane commentsScroller = new JScrollPane();
        commentsScroller.setBounds(0, 150, 420, 350);
        add(commentsScroller);
        commentsScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        comments.setFont(new Font("Dialog", Font.PLAIN, 12));
        comments.setFixedCellHeight(20);
        commentsScroller.setViewportView(comments);
        comments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        comments.setVisibleRowCount(-1);
        
        genreIdLabel = new JLabel("Id: " + model.getGenre().toString());
        genreIdLabel.setBounds(0, 0, 129, 15);
        add(genreIdLabel);
        
        trackIdLabel = new JLabel("Id: " + model.getId());
        trackIdLabel.setBounds(0, 0, 129, 15);
        add(trackIdLabel);
        
        songNameLabel = new JLabel("Name: " + model.getSongName());
        songNameLabel.setBounds(0, 30, 157, 15);
        add(songNameLabel);
        
        artistNameLabel = new JLabel("Brand: " + model.getArtistName());
        artistNameLabel.setBounds(160, 30, 129, 15);
        add(artistNameLabel);
        
        durationLabel = new JLabel("Type: " + model.getDuration());
        durationLabel.setBounds(160, 57, 164, 15);
        add(durationLabel);;
        
        likeCountLabel = new JLabel("Likes: " + model.getLikeCount());
        likeCountLabel.setBounds(0, 125, 129, 15);
        add(likeCountLabel);
        
        popularityLabel = new JLabel("Dislikes: " + model.getPopularity());
        popularityLabel.setBounds(160, 123, 129, 15);
        add(popularityLabel);
        
        sendButton = new JButton("Send");
        sendButton.setBounds(310, 602, 110, 25);
        add(sendButton);
        
        likeButton = new JButton("Like");
        likeButton.setBounds(0, 510, 110, 25);
        add(likeButton);
                
        addCollectionButton = new JButton("Add Collection");        
        addCollectionButton.setBounds(270, 510, 150, 25);
        add(addCollectionButton);
        
        playButton = new JButton("Dislike");
        playButton.setBounds(135, 510, 110, 25);
        add(playButton);        
	}
	
	public void addAddToPlaylistButtonListener(ActionListener listener) {
		addCollectionButton.addActionListener(listener);
	}
	
	public void addLikeButtonListener(ActionListener listener) {
		likeButton.addActionListener(listener);
	}
	
	public void addPlayButtonListener(ActionListener listener) {
		playButton.addActionListener(listener);
	}
	
	public void addSendButtonListener(ActionListener listener) {
		sendButton.addActionListener(listener);
	}
	

	@Override
	public void update(SongEvent event) {
		switch (event) {
			case LIKE:
			case REMOVE_LIKE:
				likeCountLabel.setText("Likes: " + model.getLikeCount());
				break;
			case PLAY:
				// To-Do: play iþlemini yaptýrmak
				break;
			default:
				break;
		}
	}
}
