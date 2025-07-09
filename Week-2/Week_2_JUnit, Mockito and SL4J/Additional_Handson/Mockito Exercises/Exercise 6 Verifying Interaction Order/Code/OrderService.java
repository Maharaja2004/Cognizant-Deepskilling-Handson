package com.example;

public class OrderService {
	private OrderApi api;

    public OrderService(OrderApi api) {
        this.api=api;
    }

    public void executeSteps() {
        api.stepOne();
        api.stepTwo();
        api.stepThree();
    }
}
