package ProxyPatternExample;

public class RealImage implements Image {
	
	private String filename;
	
	public RealImage(String filename) {
		this.filename=filename;
		loadFromServer();
	}
	private void loadFromServer() {
		System.out.println("Loading image form server:"+filename);
	}
	public void display() {
		System.out.println("Displaying image:"+filename);
	}

}
