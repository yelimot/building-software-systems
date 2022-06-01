package data;

import java.io.IOException;
import java.util.List;

/**
 * Loads data from storage
 * 
 * @param <T> model
 */
public interface IDataLoader<T> {
	/**
	 * Loads data
	 * 
	 * @return loaded data
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	List<T> load() throws NumberFormatException, IOException;
}
