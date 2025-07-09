package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ExceptionThrowerTest {
	@Test
    public void testExceptionThrown() {
        ExceptionThrower obj = new ExceptionThrower();

        assertThrows(IllegalArgumentException.class, () -> {
            obj.throwException();
        });
    }
}
