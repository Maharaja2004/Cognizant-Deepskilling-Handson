package SingletonPattern;

public class Logger {
 
	private static Logger instance;
	
	private Logger(){
		System.out.println("Example for Singleton Pattern");
	}
	
	public static Logger getInstance() {
		if(instance==null) {
			instance=new Logger();
		}
		return instance;
	}
	
}
