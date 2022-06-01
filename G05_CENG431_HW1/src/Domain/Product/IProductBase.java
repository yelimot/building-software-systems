package Domain.Product;

public interface IProductBase extends Cloneable {
	
	public String getProductId();

	public void setPriceOfThatProduct(int priceOfProduct);
	
	public void setQuantityOfProduct(int quantityOfProduct);
	
	public int getQuantityOfProduct();
	
	public int getPriceOfThatProduct();
	
	public int getRevenueFromProduct(); 
	
	/** 
	* Sets revenue from product by calculating {QuantityOfProduct*PriceOfProduct}.
	*/
	public void setRevenueFromProduct();

	/** 
	* Clone method to store products in baskets.
	*/
	public ProductBaseClass clone() throws CloneNotSupportedException;
}
