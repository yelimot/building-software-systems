package Controller;

import java.util.ArrayList;

import Domain.Basket.Basket;
import Domain.Product.IProductBase;

public interface IQuery {
	/*
	 * 1- The revenue from COLI-1 product. 
	 */
	public void Query1(ArrayList<Basket> basketRepository);
	
	/*
	 * 2- Top selling product by quantity.
	 */
	public void Query2(ArrayList<Basket> basketRepository, ArrayList<IProductBase> productRepository);
	
	/*
	 * 3- The most paid basket.
	 */
	public void Query3(ArrayList<Basket> basketRepository);
	
	/*
	 * 4- Basket with the largest number of different products.
	 */
	public void Query4(ArrayList<Basket> basketRepository);
	
	/*
	 * 5- The month in which the ELPC-1 was sold the most expensive.
	 */
	public void Query5(ArrayList<Basket> basketRepository, ArrayList<IProductBase> productRepository);
	
	/*
	 * 6- Price increase rate of ELHE-2 in July
	 */
	public void Query6(ArrayList<Basket> basketRepository);
}
