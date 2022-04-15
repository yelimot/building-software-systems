package Domain.Product;

public class ProductBaseClass implements IProductBase {
	private String ProductId;
	private int QuantityOfProduct; // sold quantity of that instance
	private int PriceOfProduct = 0; // see setPriceOfThatProduct(int priceOfProduct) in FileIO
	private int RevenueFromProduct = 0; // see setRevenueFromProduct() in FileIO
	
	public ProductBaseClass(String productId) {
		ProductId = productId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		ProductId = productId;
	}

	public int getQuantityOfProduct() {
		return QuantityOfProduct;
	}

	public void setQuantityOfProduct(int quantityOfProduct) {
		QuantityOfProduct = quantityOfProduct;
	}
	
	public int getRevenueFromProduct() {
		return RevenueFromProduct;
	}

	public void setRevenueFromProduct() {
		RevenueFromProduct = QuantityOfProduct*PriceOfProduct;
	}

	public int getPriceOfThatProduct() {
		return PriceOfProduct;
	}

	public void setPriceOfThatProduct(int priceOfProduct) {
		PriceOfProduct = priceOfProduct;
	}
	
	 @Override
	public ProductBaseClass clone() throws CloneNotSupportedException {
		 ProductBaseClass productBaseClass = (ProductBaseClass) super.clone();
		 return productBaseClass;        // return deep copy
    }
	
}
