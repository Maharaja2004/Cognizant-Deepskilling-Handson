package com.example;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorLifecycleTest {

	 private Calculator c;
	 
	 @Before
	 public void setup() {
		 c=new Calculator();
		 System.out.println("Setup Completed");
	 }
	 
	 @After
	 public void teardown() {
		 c=null;
		 System.out.println("Teardown Completed");
	 }
	 
	 @Test
	 public void positivetest() {
		 int result=c.add(10, 30);
		 assertEquals(40,result);
	 }
	 
	 @Test
	 public void negativetest() {
		 int result=c.add(-5, -30);
		 assertEquals(-35,result);
		 
	 }
}
