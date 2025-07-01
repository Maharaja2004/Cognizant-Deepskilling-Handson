package ProxyPatternExample;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image img1=new ProxyImage("cat.png");
		Image img2=new ProxyImage("dog.png");
		
		img1.display();
		img1.display();
		img2.display();

	}

}
