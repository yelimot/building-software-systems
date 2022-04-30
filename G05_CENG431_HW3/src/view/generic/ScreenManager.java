package view.generic;

import javax.swing.JPanel;

import app.Session;
import controller.FollowedUsersController;
import controller.HomeController;
import controller.IController;
import controller.LoginController;
import controller.PlaylistController;
import data.IStatistics;
import model.models.song.SongRepository;
import model.models.user.User;
import model.models.user.UserRepository;
import view.components.HeaderPanel;
import view.generic.contracts.IScreenManager;
import view.pages.FollowedUsers;
import view.pages.Home;
import view.pages.Login;
import view.pages.PlaylistsPanel;
import view.pages.Statistics;


public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private JPanel view;
	private IController controller;
	
	private UserRepository userRepository;
	private SongRepository songRepository;

	public ScreenManager(MainWindow window, UserRepository userRepository, SongRepository songRepository) {
		this.window = window;
		this.userRepository = userRepository;
		this.songRepository = songRepository;
	}
	
	public void run() {
		showLoginScreen();
		window.setVisible(true);
	}
	
	public void onLoginSuccess(User user) {
		Session.setUser(user);
		window.setHeader(new HeaderPanel(this, user));
		showHomeScreen();
	}
	
	public void onLogout() {
		Session.setUser(null);
		window.setHeader(null);
		showLoginScreen();
	}
	
	public void onPageChanged(MenuModel model) {
		controller.destroy();
		
		switch (model) {
			case HOME:
				showHomeScreen();
				break;
			case COLLECTIONS:
				showCollectionsScreen();
				break;
			case FOLLOWED_USERS:
				showFollowedUsersScreen();
				break;
			case STATISTICS:
				showStatisticsScreen();
				break;
			default:
				break;
		}
	}
	
	private void showLoginScreen() {
		window.setContent(new Login(new LoginController(this, userRepository)));
	}
	
	private void showHomeScreen() {
		this.view = new Home(songRepository);
		this.controller = new HomeController((Home) view, songRepository);
		
		window.setContent(view);
	}
	
	private void showCollectionsScreen() {
		User model = Session.getUser();
		this.view = new PlaylistsPanel(model);
		this.controller = new PlaylistController((PlaylistsPanel) view, model);
		
		window.setContent(view);
	}
	
	private void showFollowedUsersScreen() {
		User model = Session.getUser();
		FollowedUsers view = new FollowedUsers(model);
		controller = new FollowedUsersController(view, model, userRepository);
		window.setContent(view);
	}
	
	private void showStatisticsScreen() {
		IStatistics statistics = Session.getStatistics();
		window.setContent(new Statistics(statistics));
	}
}
