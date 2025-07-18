package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;
@Service
public class BookService {
	private BookRepository bookrep;
	private String Libname;
	
	public BookService(String Lib) {
		this.Libname=Lib;
		System.out.println("BookService Constructor Called");
	}
	
	public void setbookrep(BookRepository bookrep) {
		this.bookrep=bookrep;
	}
	
	public void print(String bookName) {
		System.out.println("Library Name is:"+Libname);
        System.out.println("Print Method is called from Service Class");
        bookrep.print(bookName);
    }

}
