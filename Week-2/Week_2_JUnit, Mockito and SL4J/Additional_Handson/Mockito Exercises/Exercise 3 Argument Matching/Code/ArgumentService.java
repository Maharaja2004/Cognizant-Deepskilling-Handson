package com.example;

public class ArgumentService {
	private ArgumentApi api;

    public ArgumentService(ArgumentApi api) {
        this.api=api;
    }

    public void handleRequest() {
        api.process("Hello",3);
    }
}
