package Domain.Product.Clothing;

public class Coat extends ClothingBaseClass {
	private String CoatType;

	public Coat(String productId, String brand, String size, String coatType) {
		super(productId, brand, size);
		setCoatType(coatType);
	}

	public String getCoatType() {
		return CoatType;
	}

	public void setCoatType(String coatType) {
		CoatType = coatType;
	}
}
