package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.repository.BookRepository;
import com.library.service.BookService;

public class LibraryManagementApplication{

	public static void main(String[] args){
      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
      
      System.out.println();
      BookService book1=(BookService)context.getBean("bs");
      book1.print();
    
      BookRepository book2=(BookRepository)context.getBean("br");
      book2.print();
	}

}
