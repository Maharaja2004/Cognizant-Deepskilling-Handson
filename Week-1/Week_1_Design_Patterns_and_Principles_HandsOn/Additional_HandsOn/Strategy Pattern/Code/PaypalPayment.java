package StrategyPatternExample;

public class PaypalPayment implements PaymentStrategy{
   public void pay(double amount) {
	   System.out.println(amount+" paid using Paypal");
   }
}
