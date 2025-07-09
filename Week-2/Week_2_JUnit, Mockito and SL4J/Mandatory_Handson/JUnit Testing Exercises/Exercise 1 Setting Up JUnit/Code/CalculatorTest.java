package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void testAdd() {
    	Calculator c=new Calculator();
        int result=c.add(1, 4);
        assertEquals(6,result);
    }
    
}
