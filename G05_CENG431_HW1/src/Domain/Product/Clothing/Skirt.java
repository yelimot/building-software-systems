package Domain.Product.Clothing;

public class Skirt extends ClothingBaseClass {
	private String Hemline;

	public Skirt(String productId, String brand, String size, String hemline) {
		super(productId, brand, size);
		setHemline(hemline);
	}

	public String getHemline() {
		return Hemline;
	}

	public void setHemline(String hemline) {
		Hemline = hemline;
	}
	
	
}
