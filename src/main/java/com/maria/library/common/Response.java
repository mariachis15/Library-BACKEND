package com.maria.library.common;

import lombok.Data;

@Data
public class Response<T> {
    private T response;
    private boolean isError;
    private String error;

    public Response(T response) {
        this.response = response;
        isError = false;
    }

    public Response(Exception exception) {
        this.isError = true;
        this.error = exception.getMessage();
    }
}
