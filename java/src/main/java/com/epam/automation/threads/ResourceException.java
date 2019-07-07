package com.epam.automation.threads;

public class ResourceException extends Exception {

    public ResourceException(String message) {
        super(message);
    }

    public ResourceException(Throwable cause) {
        super(cause);
    }
}
