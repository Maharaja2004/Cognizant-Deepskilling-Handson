package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	
	public void print(String msg) {
		System.out.println(msg);
	}
}
