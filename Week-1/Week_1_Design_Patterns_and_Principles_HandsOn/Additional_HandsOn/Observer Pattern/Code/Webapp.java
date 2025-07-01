package ObserverPatternExample;

public class Webapp implements Observer{
	public void update(String stockName,double price) {
		System.out.println("Web App:"+stockName+"Price:"+price);
	}

}
