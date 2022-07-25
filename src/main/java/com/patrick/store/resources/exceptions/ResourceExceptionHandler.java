package com.patrick.store.resources.exceptions;

import com.patrick.store.service.exeptions.DataIntegrityException;
import com.patrick.store.service.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
                                                          HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        String errorMessage = status.getReasonPhrase();
        StandardError error = new StandardError(Instant.now(),
                status.value(), errorMessage, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e,
                                                          HttpServletRequest request){

        HttpStatus status = HttpStatus.BAD_REQUEST;
        String errorMessage = status.getReasonPhrase();
        StandardError error = new StandardError(Instant.now(),
                status.value(), errorMessage, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }
}
