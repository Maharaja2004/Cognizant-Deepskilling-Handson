package com.example;

import org.junit.Test;
import static org.mockito.Mockito.*;
public class MyServiceVerifyTest {
	@Test
	public void testVerifyInteraction() {
		ExternalApi mockapi=mock(ExternalApi.class);
		MyService serv=new MyService(mockapi);
		serv.fetchData();
		verify(mockapi).getData();
	}

}
