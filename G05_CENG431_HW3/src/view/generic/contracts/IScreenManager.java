package view.generic.contracts;

import model.models.user.User;
import view.generic.MenuModel;

/**
 * Handles view changes
 */
public interface IScreenManager {
	/**
	 * Starts main window
	 */
	void run();
	
	/**
	 * Successful login handler
	 * 
	 * @param user logged in user
	 */
	void onLoginSuccess(User user);
	
	/**
	 * Page change handler
	 * 
	 * @param model new screen name
	 */
	void onPageChanged(MenuModel model);
	
	/**
	 * Logout handler
	 */
	void onLogout();
}