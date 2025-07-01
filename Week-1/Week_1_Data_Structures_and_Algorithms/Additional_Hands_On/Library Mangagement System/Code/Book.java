package LibraryManagementSystem;

public class Book {
   private int bookid;
   private String title;
   private String author;
   
   public void setBook(int bookid) {
	   this.bookid=bookid;
   }
   public void setTitle(String title) {
	   this.title=title;
   }
   public void setAuthor(String author) {
	   this.author=author;
   }
   public int getBookId() {
	   return bookid;
   }
   public String getTitle() {
	   return title;
   }
   public String getAuthor() {
	   return author;
   }
   public void display() {
	   System.out.println("ID:"+bookid+", Title: "+title+", Author: "+author);
   }
}
