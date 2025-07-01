package LibraryManagementSystem;

import java.util.*;
public class Library {
  ArrayList<Book> books=new ArrayList<>();
  
  public void addbook(Book b) {
	  books.add(b);
  }
  
  public void linearsearch(String searchtitle) {
	  boolean f=false;
	  for(Book b:books) {
		  if (b.getTitle().equalsIgnoreCase(searchtitle)) {
              b.display();
              f=true;
          }
      }
      if (!f) {
          System.out.println("Book not found.");
      }
  }
  public void binarysearch(String searchTitle) {
     
      Collections.sort(books, new Comparator<Book>() {
          public int compare(Book b1, Book b2) {
              return b1.getTitle().compareToIgnoreCase(b2.getTitle());
          }
      });

      int l=0;
      int r=books.size()-1;
      boolean f=false;

      while(l<=r){
          int mid=(l+r)/2;
          String midtitle=books.get(mid).getTitle();

          if (midtitle.equalsIgnoreCase(searchTitle)) {
              books.get(mid).display();
              f=true;
              break;
          } 
          else if(midtitle.compareToIgnoreCase(searchTitle) < 0) {
              l=mid+1;
          } 
          else{
              r=mid-1;
          }
      }

      if(!f) {
          System.out.println("Book not found.");
      }
	  }
  }

