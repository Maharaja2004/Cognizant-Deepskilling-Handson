package com.example;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;
public class OrderServiceTest {
	@Test
    public void testInteractionOrder() {
        OrderApi mockApi=mock(OrderApi.class);

        OrderService service=new OrderService(mockApi);
        service.executeSteps();

        
        InOrder inOrder=inOrder(mockApi);
        inOrder.verify(mockApi).stepOne();
        inOrder.verify(mockApi).stepTwo();
        inOrder.verify(mockApi).stepThree();
    }
}
