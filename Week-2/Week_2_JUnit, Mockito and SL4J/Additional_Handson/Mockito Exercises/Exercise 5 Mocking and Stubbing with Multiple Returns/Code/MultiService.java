package com.example;

public class MultiService {
	private MultiApi api;

    public MultiService(MultiApi api) {
        this.api=api;
    }

    public String callOnce() {
        return api.getResponse();
    }

    public String callTwice() {
        return api.getResponse()+" & "+api.getResponse();
    }
}
