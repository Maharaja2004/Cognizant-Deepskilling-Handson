package StrategyPatternExample;

public class PaymentContext {
   private PaymentStrategy strategy;
   
   public void setpayment(PaymentStrategy strategy) {
	   this.strategy=strategy;
   }
   public void payamount(double amount) {
	   strategy.pay(amount);
   }
}
