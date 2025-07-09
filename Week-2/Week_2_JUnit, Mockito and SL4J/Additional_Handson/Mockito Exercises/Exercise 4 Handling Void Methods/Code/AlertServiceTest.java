package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class AlertServiceTest {
	@Test
    public void testVoidMethodInteraction() {
        Notifier mockNotifier = mock(Notifier.class);


        AlertService alertService = new AlertService(mockNotifier);
        alertService.triggerAlert();

       
        verify(mockNotifier).send("Emergency Alert!");
    }
}
