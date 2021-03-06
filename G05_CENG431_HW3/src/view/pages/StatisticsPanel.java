package view.pages;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.IStatistics;
import model.models.song.Song;
import model.models.user.User;

/**
 * Shows statistics:
 * - Most liked song,
 * - Most disliked song,
 * - Most followed user.
 */
public class StatisticsPanel extends JPanel {
	private static final long serialVersionUID = -669290185768399715L;
	
	public StatisticsPanel(IStatistics model) {
		User mostFollowed = model.getMostFollowedUser();
		Song mostLiked = model.getMostLikedSong();
		Song mostPopular = model.getMostPopularSong();
		
        setSize(960, 685);
        setLayout(null);
        
        JLabel mostLikedLabel = new JLabel("The Most Liked Song:");
        mostLikedLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostLikedLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostLikedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostLikedLabel.setBounds(0, 112, 960, 45);
        add(mostLikedLabel);
        
        JLabel mostPopularLabel = new JLabel("The Most Popular Song:");
        mostPopularLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        mostPopularLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mostPopularLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        mostPopularLabel.setBounds(0, 245, 960, 45);
        add(mostPopularLabel);
        
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
        
        JLabel mostPopularLabel_1 = new JLabel(mostPopular.toString());
        mostPopularLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
        mostPopularLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        mostPopularLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        mostPopularLabel_1.setBounds(0, 290, 960, 45);
        add(mostPopularLabel_1);
                
        JLabel mostFollowedUserLabel_1 = new JLabel(mostFollowed.toString());
        mostFollowedUserLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
        mostFollowedUserLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        mostFollowedUserLabel_1.setFont(new Font("Dialog", Font.PLAIN, 24));
        mostFollowedUserLabel_1.setBounds(0, 422, 960, 45);
        add(mostFollowedUserLabel_1);
        setVisible(true);
	}
}
