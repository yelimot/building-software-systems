package Domain.Product.Cosmetic;

public class Lipstick extends CosmeticBaseClass {
	private String LipstickType;
	private String Color;
	
	public Lipstick(String productId, String brand, int mL, String lipstickType, String color) {
		super(productId, brand, mL);
		setLipstickType(lipstickType);
		setColor(color);
	}

	public String getLipstickType() {
		return LipstickType;
	}

	public void setLipstickType(String lipstickType) {
		LipstickType = lipstickType;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}
	
	
	
}
