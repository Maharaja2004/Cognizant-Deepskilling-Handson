package com.library.service;



import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookrep;
	
	public BookService(BookRepository bookrep) {
		this.bookrep=bookrep;
	}
	
	public void addBook(String bookname) {
		System.out.println("BookService:Adding Book......");
		bookrep.save(bookname);
	}	

}
