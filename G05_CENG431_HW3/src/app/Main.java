package app;

import java.awt.EventQueue;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import data.IDataLoader;
import data.SongLoader;
import data.SongMonitoredSaver;
import data.SongSaver;
import data.Statistics;
import data.UserLoader;
import data.UserMonitoredSaver;
import data.UserSaver;
import model.models.song.Song;
import model.models.song.SongRepository;
import model.models.user.User;
import model.models.user.UserRepository;
import view.generic.MainWindow;
import view.generic.ScreenManager;
import view.generic.contracts.IScreenManager;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, NumberFormatException, IOException {
		// Load outfits
		IDataLoader<Song> songLoader = new SongLoader("./tracks.txt");
		SongSaver songSaver = new SongSaver("./tracks.txt");
		SongRepository songRepository = new SongRepository(songLoader, songSaver);
		
		// Load users
		IDataLoader<User> userLoader = new UserLoader("./users.xml", songRepository);
		UserSaver userSaver = new UserSaver("./users.xml");
		UserRepository userRepo = new UserRepository(userLoader, userSaver);
		
		// Save playlists
		
			
		// Start automatic savers
		new SongMonitoredSaver(songRepository);
		new UserMonitoredSaver(userRepo);
		
		// Registers statistics instance
		Session.setStatistics(new Statistics(userRepo, songRepository));
		
		// Runs program
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					IScreenManager screenManager = new ScreenManager(window, userRepo, songRepository);
					screenManager.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}