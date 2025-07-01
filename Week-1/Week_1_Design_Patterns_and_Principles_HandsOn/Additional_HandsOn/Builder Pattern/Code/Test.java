package BuilderPatternExample;

public class Test {
   public static void main(String args[]) {
	   
	   Computer c1=new Computer.Builder()
			                   .setcpu("Intel i5")
			                   .setram("8GB")
			                   .setstorage("512GB SSD")
			                   .build();
	   System.out.println("Configuration of C1 is: ");
	   c1.display();
	   System.out.println();
	   
	   Computer c2=new Computer.Builder()
			                   .setcpu("AMD Ryzen")
	                           .setram("16GB")
	                           .setstorage("1TB HDD")
	                           .build();
	   System.out.println("Configuration of C2 is:");
	   c2.display();
   }
}
