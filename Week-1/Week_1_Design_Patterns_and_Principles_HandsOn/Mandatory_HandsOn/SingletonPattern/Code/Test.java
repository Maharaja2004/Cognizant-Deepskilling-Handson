package SingletonPattern;

public class Test {

	public static void main(String[] args) {
		
		Logger object1=Logger.getInstance();
		Logger object2=Logger.getInstance();
		Logger object3=Logger.getInstance();
		Logger object4=Logger.getInstance();
		
		
		System.out.println(object1);
		System.out.println(object2);
		
		System.out.println(object1==object2);
		System.out.println(object1==object4);
		System.out.println(object3==object2);
	}

}
