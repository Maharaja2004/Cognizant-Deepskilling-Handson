package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionServiceTest {
	@Test
    public void testVoidMethodThrowsException() {
        ExceptionNotifier mockNotifier=mock(ExceptionNotifier.class);

       
        doThrow(new RuntimeException("Mock Exception"))
            .when(mockNotifier).alert("Something went wrong!");

        ExceptionService service=new ExceptionService(mockNotifier);

       
        assertThrows(RuntimeException.class, () -> {
            service.notifyUser();
        });

        // Verify alert method was called
        verify(mockNotifier).alert("Something went wrong!");
    }
}
