package model.utils;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generic model container
 *
 * @param <T> model
 */
public interface IRepository<T> {
	/**
	 * Get model by id
	 * 
	 * @param id model id
	 * @return model
	 */
	Optional<T> get(Object id);
	
	/**
	 * Get model by predicate
	 * 
	 * @param predicate search criteria
	 * @return model
	 */
	Optional<T> get(Predicate<T> predicate);
	
	/**
	 * Get all models
	 * 
	 * @return models
	 */
	List<T> getAll();
	
	/**
	 * Get models by predicate
	 * 
	 * @param predicate search criteria
	 * @return models
	 */
	List<T> getAll(Predicate<T> predicate);
	
	/**
	 * Save data
	 */
	void save();
}

