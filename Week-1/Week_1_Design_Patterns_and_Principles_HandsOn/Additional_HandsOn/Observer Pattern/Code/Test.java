package ObserverPatternExample;

public class Test {

	public static void main(String[] args) {
		StockMarket market=new StockMarket();
		
		Observer mobile=new Mobileapp();
		Observer web=new Webapp();
		
		market.register(mobile);
		market.register(web);
		
		market.setstock("TCS", 3450.75);
		market.setstock("Infosys", 1499.50);
		
		market.deregister(web);
		market.setstock("Wipro", 412.60);
	}

}
