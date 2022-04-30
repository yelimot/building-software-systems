package view.pages;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.IStatistics;
import model.models.song.Song;
import model.models.user.User;

import java.awt.Font;

/**
 * Shows statistics:
 * - Most liked song,
 * - Most followed user.
 */
public class Statistics extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	public Statistics(IStatistics model) {
		User mostFollowed = model.getMostFollowedUser();
		Song mostLiked = model.getMostLikedSong();
		
        setSize(960, 685);
        setLayout(null);
        
        JLabel mostLikedLabel = new JLabel("The Most Liked Outfit:");
        mostLikedLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostLikedLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostLikedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostLikedLabel.setBounds(0, 112, 960, 45);
        add(mostLikedLabel);
        
        JLabel mostFollowedUserLabel = new JLabel("The Most Followed User:");
        mostFollowedUserLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostFollowedUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostFollowedUserLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostFollowedUserLabel.setBounds(0, 376, 960, 45);
        add(mostFollowedUserLabel);
        
        JLabel mostLikedLabel_1 = new JLabel(mostLiked.toString());
        mostLikedLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
        mostLikedLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        mostLikedLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        mostLikedLabel_1.setBounds(0, 156, 960, 45);
        add(mostLikedLabel_1);
        
        JLabel mostFollowedUserLabel_1 = new JLabel(mostFollowed.toString());
        mostFollowedUserLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
        mostFollowedUserLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        mostFollowedUserLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        mostFollowedUserLabel_1.setBounds(0, 422, 960, 45);
        add(mostFollowedUserLabel_1);
        setVisible(true);
	}
}
