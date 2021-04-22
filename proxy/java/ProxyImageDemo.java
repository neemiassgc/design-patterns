interface Image {

	void display();
}

final class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Display: "+this.fileName);
	}
}

final class ProxyImage implements Image {

	private String fileName;
	private Image realImage;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Display: "+this.fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Load: "+fileName);
	}
}

final class ProxyImageDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("test_10mb.jpg");

		//image will be loaded from disk
		image.display(); 
		System.out.println("");

		//image will not be loaded from disk
		image.display(); 	
	}
}