package AdapterPatternExample;

public class StripeAdapter implements PaymentProcessor {
	Stripe s=new Stripe();
	
	public void processpayment(double amount) {
		s.sendpayment(amount);
	}

}
