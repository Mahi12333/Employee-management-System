package org.example.excption;

public class ResourceNoFound extends RuntimeException {
    public ResourceNoFound(String message) {
        super(message);
    }
}
