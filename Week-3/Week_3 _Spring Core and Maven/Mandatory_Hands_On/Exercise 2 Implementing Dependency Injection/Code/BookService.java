package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookrep;
	
	
	public void setBookrep(BookRepository bookrep) {
		this.bookrep=bookrep;
	}
	public void print(String bookName) {
        System.out.println("Registering book: " + bookName);
        bookrep.print(bookName);
    }

}
