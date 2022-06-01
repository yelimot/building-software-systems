package Domain.Product.Electronic;

public class Phone extends ElectronicBaseClass {
	private int MemCapacity;

	public Phone(String productId, String title, int memCapacity) {
		super(productId, title);
		setMemCapacity(memCapacity);
	}

	public int getMemCapacity() {
		return MemCapacity;
	}

	public void setMemCapacity(int memCapacity) {
		MemCapacity = memCapacity;
	}
}
