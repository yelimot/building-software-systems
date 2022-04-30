package view.generic;

import javax.swing.JPanel;

import view.generic.contracts.IScreenManager;


public class ScreenManager implements IScreenManager {
	private final MainWindow window;
	private JPanel view;
	private IController controller;
	
	private UserRepository userRepo;
	private OutfitRepository outfitRepo;

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
		window.setContent(new LoginPanel(new LoginController(this, userRepo)));
	}
	
	private void showHomeScreen() {
		this.view = new HomePanel(outfitRepo);
		this.controller = new HomeController((HomePanel) view, outfitRepo);
		
		window.setContent(view);
	}
	
	private void showCollectionsScreen() {
		User model = Session.getUser();
		this.view = new CollectionsPanel(model);
		this.controller = new CollectionsController((CollectionsPanel) view, model);
		
		window.setContent(view);
	}
	
	private void showFollowedUsersScreen() {
		User model = Session.getUser();
		FollowedUsersPanel view = new FollowedUsersPanel(model);
		controller = new FollowedUsersController(view, model, userRepo);
		window.setContent(view);
	}
	
	private void showStatisticsScreen() {
		IStatistics statistics = Session.getStatistics();
		window.setContent(new StatisticsPanel(statistics));
	}
}
