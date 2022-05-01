package data;

import data.monitor.IMonitor;
import data.monitor.MostFollowedUserMonitor;
import data.monitor.MostLikedSongMonitor;
import data.monitor.MostPopularSongMonitor;
import model.enums.SongEvent;
import model.enums.UserEvent;
import model.models.playlist.Playlist;
import model.models.playlist.PlaylistEvent;
import model.models.song.Song;
import model.models.user.User;
import model.utils.IRepository;

public class Statistics implements IStatistics {
	private IMonitor<Song, SongEvent> mostLikedSongMonitor;
	private IMonitor<User, UserEvent>  mostFollowedUserMonitor;
	private IMonitor<Song, SongEvent> mostPopularSongMonitor;
	private IMonitor<Playlist, PlaylistEvent> shortestPlaylistMonitor;
	private IMonitor<Playlist, PlaylistEvent> longestPlaylistMonitor;
	
	public Statistics(IRepository<User> usersRepo, IRepository<Song> songsRepo) {
		mostLikedSongMonitor = new MostLikedSongMonitor(songsRepo);
		mostFollowedUserMonitor = new MostFollowedUserMonitor(usersRepo);
		mostPopularSongMonitor = new MostPopularSongMonitor(songsRepo);
//		shortestPlaylistMonitor = new ShortestPlaylistMonitor(playlistsRepo);
//		longestPlaylistMonitor = new LongestPlaylistMonitor(playlistsRepo);
	}
	
	@Override
	public Song getMostLikedSong() {
		return mostLikedSongMonitor.get();
	}


	@Override
	public User getMostFollowedUser() {
		return mostFollowedUserMonitor.get();
	}

	@Override
	public Song getMostPopularSong() {
		// TODO Auto-generated method stub
		return mostPopularSongMonitor.get();
	}

	@Override
	public Playlist getShortestPlaylist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Playlist getLongestPlaylist() {
		// TODO Auto-generated method stub
		return null;
	}
}
