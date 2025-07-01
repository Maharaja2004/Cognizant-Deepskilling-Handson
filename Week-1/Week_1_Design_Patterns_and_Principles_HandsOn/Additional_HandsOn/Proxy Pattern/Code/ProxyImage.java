package ProxyPatternExample;

public class ProxyImage implements Image{
   private String filename;
   private RealImage realimage;
   
   public ProxyImage (String filename) {
	   this.filename=filename;
   }
   
   public void display() {
	   if(realimage==null) {
		   realimage=new RealImage(filename);
	   }
	   realimage.display();
   }
}
