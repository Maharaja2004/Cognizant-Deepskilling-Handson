package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
public class MathUtilityTest {
	@Test
    public void testAdd() {
        MathUtility mu=new MathUtility();
        assertEquals(7,mu.add(3,4));
    }

    @Test
    public void testSubtract() {
        MathUtility mu=new MathUtility();
        assertEquals(2,mu.subtract(5,3));
    }

    @Test
    public void testIsPositive() {
        MathUtility mu=new MathUtility();
        assertTrue(mu.isPositive(10));
        assertFalse(mu.isPositive(-5));
    }
}
