package Domain.Product.Electronic;

public class PC extends ElectronicBaseClass {
	private int RamCapacity;
	private int SDDCapacity;
	private String CPU;
	
	public PC(String productId, String title, int ramCapacity, int sDDCapacity, String cPU) {
		super(productId, title);
		RamCapacity = ramCapacity;
		SDDCapacity = sDDCapacity;
		CPU = cPU;
	}

	public int getRamCapacity() {
		return RamCapacity;
	}

	public void setRamCapacity(int ramCapacity) {
		RamCapacity = ramCapacity;
	}

	public int getSDDCapacity() {
		return SDDCapacity;
	}

	public void setSDDCapacity(int sDDCapacity) {
		SDDCapacity = sDDCapacity;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}
	
	
}
