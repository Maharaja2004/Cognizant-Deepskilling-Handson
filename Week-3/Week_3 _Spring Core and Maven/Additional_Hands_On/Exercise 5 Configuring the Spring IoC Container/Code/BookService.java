package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookrep;
	
	public void setrepo(BookRepository bookname) {
		this.bookrep=bookname;
	}
	 
	public void print(String bookName) {
        System.out.println("Print Method is called from Service Class");
        bookrep.print(bookName);
    }

}
