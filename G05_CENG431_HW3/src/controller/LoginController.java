package controller;

import model.exceptions.LoginFailException;
import model.models.user.User;
import model.utils.IRepository;
import view.generic.contracts.IScreenManager;

public class LoginController implements IController {
	private IRepository<User> userRepository;
	private IScreenManager screenManager;
	
	public LoginController(IScreenManager screenManager, IRepository<User> userRepository) {
		this.screenManager = screenManager;
		this.userRepository = userRepository;
	}
	
	public void login(String username, String password) throws LoginFailException {
		User user = userRepository.get(u -> u
				.getUsername().equals(username) 
				&& u.checkPassword(password))
				.orElseThrow(LoginFailException::new);
		screenManager.onLoginSuccess(user);
	}
	
	 @Override
	 public void destroy() {}
	
	
}
