package ObserverPatternExample;

public class Mobileapp implements Observer {
	public void update(String stockName,double price) {
		System.out.println("Mobile App:"+stockName+"price:"+price);
	}

}
