package FactoryMethodPatternExample;

public class Test {
   public static void main(String args[]) {
	   DocumentFactory wordFactory=new WordFactory();
	   Document word=wordFactory.createDocument();
	   word.open();
	   
	   
	   DocumentFactory excelFactory=new ExcelFactory();
	   Document excel=excelFactory.createDocument();
	   excel.open();
	   
	   
	   DocumentFactory pdfFactory=new PdfFactory();
	   Document pdf=pdfFactory.createDocument();
	   pdf.open();
	   
   }
}
