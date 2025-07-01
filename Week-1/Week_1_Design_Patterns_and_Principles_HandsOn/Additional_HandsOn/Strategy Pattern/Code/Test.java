package StrategyPatternExample;

public class Test {
  public static void main(String args[]) {
	  PaymentContext cont=new PaymentContext();
	  
	  cont.setpayment(new CreditCardPayment());
	  cont.payamount(1000.00);
	  cont.setpayment(new PaypalPayment());
	  cont.payamount(2500.00);
  }
}
