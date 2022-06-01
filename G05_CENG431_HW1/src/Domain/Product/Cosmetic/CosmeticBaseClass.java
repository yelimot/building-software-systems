package Domain.Product.Cosmetic;

import Domain.Product.ProductBaseClass;

public class CosmeticBaseClass extends ProductBaseClass {
	private String Brand;
	private int ML;
	
	public CosmeticBaseClass(String productId, String brand, int mL) {
		super(productId);
		setBrand(brand);
		setML(mL);
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public int getML() {
		return ML;
	}

	public void setML(int mL) {
		ML = mL;
	}
	
	
}
