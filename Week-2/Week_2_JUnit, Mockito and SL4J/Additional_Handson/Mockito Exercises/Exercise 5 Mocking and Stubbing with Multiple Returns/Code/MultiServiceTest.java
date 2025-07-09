package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
public class MultiServiceTest {
	@Test
    public void testMultipleReturns() {
        MultiApi mockApi = mock(MultiApi.class);

        
        when(mockApi.getResponse()).thenReturn("One", "Two");

        MultiService service = new MultiService(mockApi);


        assertEquals("One", service.callOnce());

        assertEquals("Two & Two", service.callTwice());
    }
}
