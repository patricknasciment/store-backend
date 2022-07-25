package com.patrick.store.service.exeptions;

import java.io.Serial;

public class DataIntegrityException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public DataIntegrityException(String msg) {
        super(msg);
    }
}
