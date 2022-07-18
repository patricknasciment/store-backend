package com.patrick.store.service.exeptions;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Integer id) {
        super("Resource not found. Id " + id);
    }
}
