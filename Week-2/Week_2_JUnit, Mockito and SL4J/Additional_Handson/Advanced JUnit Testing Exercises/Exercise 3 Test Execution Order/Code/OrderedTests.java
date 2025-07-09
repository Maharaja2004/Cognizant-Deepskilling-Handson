package com.example;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;
	@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
	public class OrderedTests {

	    @Test
	    @Order(2)
	    public void testSecond() {
	        System.out.println("Running testSecond()");
	        assertTrue(10>5);
	    }

	    @Test
	    @Order(1)
	    public void testFirst() {
	        System.out.println("Running testFirst()");
	        assertEquals(5,2+3);
	    }

	    @Test
	    @Order(3)
	    public void testThird() {
	        System.out.println("Running testThird()");
	        assertNotNull("Hello");
	    }
}
