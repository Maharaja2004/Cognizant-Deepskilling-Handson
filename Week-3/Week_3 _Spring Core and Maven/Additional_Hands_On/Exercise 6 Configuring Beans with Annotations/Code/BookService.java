package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.repository.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository bookrep;
	
	
	public void print(String bookName) {
        System.out.println("Print Method is called from Service Class");
        bookrep.print(bookName);
    }

}
