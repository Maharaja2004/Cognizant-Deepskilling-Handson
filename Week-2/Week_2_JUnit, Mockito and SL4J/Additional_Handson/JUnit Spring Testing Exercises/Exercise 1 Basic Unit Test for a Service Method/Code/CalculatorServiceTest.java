package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    CalculatorService cs=new CalculatorService();
    
    @Test
    public void testAdd() {
    	int res=cs.add(4, 1);
    	assertEquals(5,res);
    }
}
