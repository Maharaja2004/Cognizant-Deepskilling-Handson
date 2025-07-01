package AdapterPatternExample;

public class Test {
   public static void main(String args[]) {
	   
	   PaymentProcessor p1=new PaypalAdapter();
	   p1.processpayment(1500.00);
	   
	   PaymentProcessor p2=new StripeAdapter();
	   p2.processpayment(2500.00);
   }
}
