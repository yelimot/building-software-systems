package view.components;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.Font;

import model.enums.SongEvent;
import model.models.song.Song;
import model.utils.IObserver;

public class SongDetailPanel  extends JPanel implements IObserver<Song, SongEvent> {
	private static final long serialVersionUID = -669290185768399715L;
	private Song model;
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel artistLabel;
	private JLabel genreLabel;
	private JLabel durationLabel;
	private JLabel likeCountLabel;
	private JLabel genderLabel;
	private JLabel sizeLabel;
	private JLabel colorLabel;
	private JLabel dislikeCountLabel;
	private JButton sendButton;
	private JButton likeButton; 
	private JButton addPlaylistButton;
	
	public SongDetailPanel(JPanel parent, Song model) {
		this.model = model;
        setSize(420, 685);
        setLayout(null);
        setVisible(true);
        
        idLabel = new JLabel("Id: " + model.getId());
        idLabel.setBounds(0, 0, 129, 15);
        add(idLabel);
        
        nameLabel = new JLabel("Name: " + model.getSongName());
        nameLabel.setBounds(0, 30, 157, 15);
        add(nameLabel);
        
        artistLabel = new JLabel("Brand: " + model.getArtistName());
        artistLabel.setBounds(160, 30, 129, 15);
        add(artistLabel);
        
        genreLabel = new JLabel("Genre: " + model.getGenre());
        genreLabel.setBounds(160, 57, 164, 15);
        add(genreLabel);
        
        durationLabel = new JLabel("Ocassion: " + model.getDuration());
        durationLabel.setBounds(0, 60, 157, 15);
        add(durationLabel);
        
        genderLabel = new JLabel("Gender: " + model.getGender());
        genderLabel.setBounds(160, 90, 129, 15);
        add(genderLabel);
        
        sizeLabel = new JLabel("Sizes: " + Stream.of(model.getSizes()).map(OutfitSize::toString).collect(Collectors.joining(", ")));
        sizeLabel.setBounds(0, 90, 276, 15);
        add(sizeLabel);
        
        colorLabel = new JLabel("Colors: " + model.getColor());
        colorLabel.setBounds(300, 90, 117, 15);
        add(colorLabel);
        
        likeCountLabel = new JLabel("Likes: " + model.getLikeCount());
        likeCountLabel.setBounds(0, 125, 129, 15);
        add(likeCountLabel);
        
        likeButton = new JButton("Like");
        likeButton.setBounds(0, 510, 110, 25);
        add(likeButton);
                
        addPlaylistButton = new JButton("Add Playlist");        
        addPlaylistButton.setBounds(270, 510, 150, 25);
        add(addPlaylistButton);
        
	}
	
	public void addAddToPlaylistButtonListener(ActionListener listener) {
		addPlaylistButton.addActionListener(listener);
	}
	
	public void addLikeButtonListener(ActionListener listener) {
		likeButton.addActionListener(listener);
	}
	
	@Override
	public void update(SongEvent event) {
		switch (event) {
			case LIKE:
			case REMOVE_LIKE:
				likeCountLabel.setText("Likes: " + model.getLikeCount());
				break;
			default:
				break;
		}
	}
}
