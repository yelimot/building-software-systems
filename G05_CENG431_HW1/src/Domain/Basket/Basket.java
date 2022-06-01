package Domain.Basket;

import java.util.ArrayList;
import java.util.Date;

import Domain.Product.IProductBase;

public class Basket {
	private String BasketId;
	private Date BasketDate;
	private ArrayList<IProductBase> BasketItems = new ArrayList<IProductBase>(); 
	private int BasketValue = 0; // Total value of the basket. See increaseBasketValue (with justReadedProduct.getRevenueFromProduct() parameter) in FileIO. 
	private int ProductDiversity = 0; // Number of different products in the basket (this increases when a product cloning into the basket in FileIO).
	
	public Basket(String basketId, Date basketDate) {
		BasketId = basketId;
		BasketDate = basketDate;
	}
	
	public String getBasketId() {
		return BasketId;
	}

	public void setBasketId(String basketId) {
		BasketId = basketId;
	}

	public Date getBasketDate() {
		return BasketDate;
	}

	public void setBasketDate(Date basketDate) {
		BasketDate = basketDate;
	}

	public ArrayList<IProductBase> getBasketItems() {
		return BasketItems;
	}

	public void setBasketItems(ArrayList<IProductBase> basketItems) {
		BasketItems = basketItems;
	}

	public int getBasketValue() {
		return BasketValue;
	}

	public void setBasketValue(int basketValue) {
		BasketValue = basketValue;
	}

	public int getProductDiversity() {
		return ProductDiversity;
	}

	public void setProductDiversity() {
		ProductDiversity++;
	}

	public void increaseBasketValue(int value) {
		BasketValue += value;
	}
}
