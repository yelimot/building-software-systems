import java.io.IOException;
import java.text.ParseException;

import Controller.Query;
import Data.FileIO;

public class App {
	public static void main(String[] args) throws IOException, ParseException, CloneNotSupportedException {
		FileIO io = new FileIO();
		Query query = new Query();
		query.Query1(io.getBasketRepository());
		query.Query2(io.getBasketRepository(), io.getProductRepository());
		query.Query3(io.getBasketRepository());
		query.Query4(io.getBasketRepository());
		query.Query5(io.getBasketRepository(), io.getProductRepository());
		query.Query6(io.getBasketRepository());
	}
}
