package model.exceptions;

public class LoginFailException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public LoginFailException() {
		super("The username or password is invalid.");
	}
}
