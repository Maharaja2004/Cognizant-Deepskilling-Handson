package com.example;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class MyServiceTest {
	@Test
	public void testExternalApi() {
		ExternalApi mockapi=mock(ExternalApi.class);
		
		when(mockapi.getData()).thenReturn("Mock Data");
		
		MyService ser=new MyService(mockapi);
		
		String result=ser.fetchData();
		assertEquals("Mock Data",result);
	}
}


