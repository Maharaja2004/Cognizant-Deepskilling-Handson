package com.example;

public class NetworkService {
	private NetworkClient networkClient;

    public NetworkService(NetworkClient networkClient) {
        this.networkClient=networkClient;
    }

    public String connectToServer() {
        String result=networkClient.connect();
        return "Connected to "+result;
    }
}
