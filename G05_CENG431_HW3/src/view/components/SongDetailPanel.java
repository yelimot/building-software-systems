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
	private JButton likeButton; 
	private JButton addCollectionButton;
	private JButton playButton;
	
	public SongDetailPanel(JPanel parent, Song model) {
		this.model = model;
        setSize(420, 685);
        setLayout(null);
        setVisible(true);
        
        genreIdLabel = new JLabel("Genre: " + model.getGenre().toString());
        genreIdLabel.setBounds(0, 50, 129, 15);
        add(genreIdLabel);
        
        trackIdLabel = new JLabel("Id: " + model.getId());
        trackIdLabel.setBounds(0, 65, 129, 15);
        add(trackIdLabel);
        
        songNameLabel = new JLabel("Name: " + model.getSongName());
        songNameLabel.setBounds(0, 80, 157, 15);
        add(songNameLabel);
        
        artistNameLabel = new JLabel("Artist: " + model.getArtistName());
        artistNameLabel.setBounds(160, 80, 129, 15);
        add(artistNameLabel);
        
        durationLabel = new JLabel("Duration: " + model.getDuration());
        durationLabel.setBounds(160, 107, 164, 15);
        add(durationLabel);;
        
        likeCountLabel = new JLabel("Likes: " + model.getLikeCount());
        likeCountLabel.setBounds(0, 125, 129, 15);
        add(likeCountLabel);
        
        popularityLabel = new JLabel("Popularity: " + model.getPopularity());
        popularityLabel.setBounds(160, 123, 129, 15);
        add(popularityLabel);
        
        likeButton = new JButton("Like");
        likeButton.setBounds(0, 510, 110, 25);
        add(likeButton);
        
        playButton = new JButton("Play");
        playButton.setBounds(135, 510, 110, 25);
        add(playButton);
                
        addCollectionButton = new JButton("Add to Playlist");        
        addCollectionButton.setBounds(270, 510, 150, 25);
        add(addCollectionButton);
           
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
	

	@Override
	public void update(SongEvent event) {
		switch (event) {
			case LIKE:
			case REMOVE_LIKE:
				likeCountLabel.setText("Likes: " + model.getLikeCount());
				break;
			case PLAY:
				popularityLabel.setText("Popularity: " + model.getPopularity());
				break;
			default:
				break;
		}
	}
}
