package BuilderPatternExample;

import java.security.KeyStore.Builder;

public class Computer {
     private String cpu;
     private String ram;
     private String storage;
     
     
     private Computer(Builder builder) {
    	 this.cpu=builder.cpu;
    	 this.ram=builder.ram;
    	 this.storage=builder.storage;
     }
     
     public void display() {
    	 
         System.out.println("CPU: "+cpu);
         System.out.println("RAM: "+ram);
         System.out.println("Storage: "+storage);
     }
     
     public static class Builder{
    	 private String cpu;
         private String ram;
         private String storage;
         
         public Builder setcpu(String cpu) {
        	 this.cpu=cpu;
        	 return this;
         }
         public Builder setram(String ram) {
        	 this.ram=ram;
        	 return this;
         }
         public Builder setstorage(String storage) {
        	 this.storage=storage;
        	 return this;
         }
         
         public Computer build() {
        	 return new Computer(this);
         }
     }
}
