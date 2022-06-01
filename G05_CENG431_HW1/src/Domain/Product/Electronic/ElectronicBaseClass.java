package Domain.Product.Electronic;

import Domain.Product.ProductBaseClass;

public class ElectronicBaseClass extends ProductBaseClass{
	private String Title;

	public ElectronicBaseClass(String productId, String title) {
		super(productId);
		setTitle(title);
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}	
	
}
