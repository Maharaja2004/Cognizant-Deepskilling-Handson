package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
public class ArgumentServiceTest {
	@Test
    public void testArgumentMatching() {
        ArgumentApi mockApi=mock(ArgumentApi.class);

        ArgumentService service=new ArgumentService(mockApi);
        service.handleRequest();

      
        verify(mockApi).process(eq("Hello"),anyInt());
    }
}
