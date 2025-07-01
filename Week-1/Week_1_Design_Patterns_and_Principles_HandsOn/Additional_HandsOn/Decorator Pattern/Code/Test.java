package DecoratorPatternExample;

public class Test {
    public static void main(String args[]) {
    	Notifier email=new EmailNotifier();
    	Notifier smsandemail=new SmsNotifierDecorator(email);
    	Notifier all=new SlackNotifierDecorator(smsandemail);
    	
    	all.send("your order placed");
    }
}
