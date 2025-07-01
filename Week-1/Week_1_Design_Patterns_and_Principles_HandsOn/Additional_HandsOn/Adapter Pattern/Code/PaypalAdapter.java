package AdapterPatternExample;

public class PaypalAdapter  implements PaymentProcessor{
	
	Paypal p=new Paypal();
	
	public void processpayment(double amount) {
		p.makepayment(amount);
	}
     
}
