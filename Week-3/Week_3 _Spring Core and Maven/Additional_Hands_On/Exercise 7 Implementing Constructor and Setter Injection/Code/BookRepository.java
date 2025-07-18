package com.library.repository;

import org.springframework.stereotype.Repository;


public class BookRepository {
	
	public BookRepository() {
		System.out.println("BookRepository Constructor Called");
	}
	
	public void print(String msg) {
		System.out.println("Book Name:"+msg);
	}
}
