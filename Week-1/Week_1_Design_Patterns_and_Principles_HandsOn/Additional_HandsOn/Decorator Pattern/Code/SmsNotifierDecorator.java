package DecoratorPatternExample;

public class SmsNotifierDecorator  extends NotifierDecorator{
	public SmsNotifierDecorator(Notifier notifier) {
		super(notifier);
	}
	public void send(String msg) {
		super.send(msg);
		System.out.println("SMS:"+msg);
	}

}
