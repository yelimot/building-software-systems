package Domain.Product.Cosmetic;

public class Perfume extends CosmeticBaseClass {
	private String FragranceType;

	public Perfume(String productId, String brand, int mL, String fragranceType) {
		super(productId, brand, mL);
		setFragranceType(fragranceType);
	}

	public String getFragranceType() {
		return FragranceType;
	}

	public void setFragranceType(String fragranceType) {
		FragranceType = fragranceType;
	}
	
	
}
