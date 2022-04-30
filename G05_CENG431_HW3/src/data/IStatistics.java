package data;

import model.models.playlist.Playlist;
import model.models.song.Song;
import model.models.user.User;

/**
 * Statistics container
 */
public interface IStatistics {
	Song getMostLikedSong();
	Song getMostPopularSong();
	User getMostFollowedUser();
	Playlist getShortestPlaylist();
	Playlist getLongestPlaylist();
}
