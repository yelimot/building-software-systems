package Domain.Product.Electronic;

public class Headphone extends ElectronicBaseClass {
	private int BluetoothVersion;

	public Headphone(String productId, String title, int bluetoothVersion) {
		super(productId, title);
		setBluetoothVersion(bluetoothVersion);
	}

	public int getBluetoothVersion() {
		return BluetoothVersion;
	}

	public void setBluetoothVersion(int bluetoothVersion) {
		BluetoothVersion = bluetoothVersion;
	}
}
