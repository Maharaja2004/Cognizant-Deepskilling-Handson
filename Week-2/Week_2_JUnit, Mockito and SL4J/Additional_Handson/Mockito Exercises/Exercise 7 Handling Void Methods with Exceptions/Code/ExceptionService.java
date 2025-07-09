package com.example;

public class ExceptionService {
	private ExceptionNotifier notifier;

    public ExceptionService(ExceptionNotifier notifier) {
        this.notifier=notifier;
    }

    public void notifyUser() {
        notifier.alert("Something went wrong!");
    }
}
