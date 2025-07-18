package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookrep;
	
	
	 public BookService(BookRepository bookRepository) {
	        this.bookrep = bookRepository;
	  
	        System.out.println("BookService Constructor called");
	    }
	public void print(String bookName) {
        System.out.println("Registering book: " + bookName);
        bookrep.print(bookName);
    }

}
