package Domain.Product.Electronic;

public class Monitor extends ElectronicBaseClass{
	private String ScreenSize;

	public Monitor(String productId, String title, String screenSize) {
		super(productId, title);
		setScreenSize(screenSize);
	}

	public String getScreenSize() {
		return ScreenSize;
	}

	public void setScreenSize(String screenSize) {
		ScreenSize = screenSize;
	}
	
	
	
}
