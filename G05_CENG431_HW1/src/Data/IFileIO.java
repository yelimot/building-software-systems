package Data;

import java.io.IOException;
import java.text.ParseException;

public interface IFileIO {
	/** 
	* Reads products from the array; initialise each of row as IProductBase and store them into FileIO (like a product table of DB).
	*/
	public void readProducts(String path) throws IOException;
	/** 
	* Reads baskets from the array; initialise each of row as Basket 
	* and each basket products cloned and stored in that basket
	* after all, all baskets stored into FileIO (like a basket table of DB).
	*/
	public void readBaskets(String path) throws IOException, ParseException, CloneNotSupportedException ;
}
