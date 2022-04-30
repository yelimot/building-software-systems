package model.utils;
/**
 * Event for observer/observable
 *
 * @param <T> observe class
 */
public interface IEvent<T> {
	/**
	 * Inject observable
	 * 
	 * @param subject observable
	 * @return itself
	 */
	IEvent<T> withSubject(T subject);
	
	/**
	 * Checks if has observer added as pay-load
	 * 
	 * @return true if has otherwise false
	 */
	boolean hasSubject();
	
	/**
	 * Return subject of event
	 * 
	 * @return observable
	 */
	T getSubject();	
}
