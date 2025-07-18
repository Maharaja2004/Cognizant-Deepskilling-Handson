package com.library.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.library.service.BookService;

public class LibraryManagementApplication{

	public static void main(String[] args){
      ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
      
    
      BookService book1=(BookService)context.getBean(BookService.class);
      book1.print("Using Annotations");
      
   
     	}

}
