package view.generic.contracts;

import java.awt.Component;

/**
 * Application window
 */
public interface IWindow {
	/**
	 * Sets header
	 * 
	 * @param component component to be showed
	 */
	void setHeader(Component component);
	
	/**
	 * Sets content
	 * 
	 * @param component component to be showed
	 */
	void setContent(Component component);
}
