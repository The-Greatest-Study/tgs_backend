package com.tgs.tgs_backend.exception;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String id) {
        super("Already existing id: " + id);
    }
}
