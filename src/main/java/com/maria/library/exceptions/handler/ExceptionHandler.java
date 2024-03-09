package com.maria.library.exceptions.handler;

import com.maria.library.common.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

/*    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handle(Exception exception) {
        return new ResponseEntity<>(new Response(exception), HttpStatus.NOT_FOUND);
    }*/
}
