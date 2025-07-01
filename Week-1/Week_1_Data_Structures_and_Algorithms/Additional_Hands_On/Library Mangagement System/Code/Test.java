package LibraryManagementSystem;

public class Test {
	public static void main(String[] args) {
        Library lib=new Library();

        Book b1=new Book();
        b1.setBook(101);
        b1.setTitle("Java Programming");
        b1.setAuthor("Maharaja");

        Book b2=new Book();
        b2.setBook(102);
        b2.setTitle("Python Basics");
        b2.setAuthor("kumar");

        Book b3=new Book();
        b3.setBook(103);
        b3.setTitle("C Language");
        b3.setAuthor("varun");

        lib.addbook(b1);
        lib.addbook(b2);
        lib.addbook(b3);

        System.out.println("Searching with Linear Search:");
        lib.linearsearch("Python Basics");

        System.out.println("Searching with Binary Search:");
        lib.binarysearch("Python Basics");
    }
}
