package Domain.Product.Clothing;

import Domain.Product.ProductBaseClass;

public class ClothingBaseClass extends ProductBaseClass {
	private String Brand;
	private String Size;
	
	public ClothingBaseClass(String productId, String brand, String size) {
		super(productId);
		setBrand(brand);
		setSize(size);
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getSize() {
		return Size;
	}

	public void setSize(String size) {
		Size = size;
	}
	
	
}
