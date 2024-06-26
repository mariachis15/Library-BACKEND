package com.maria.library.common;

import lombok.Data;

@Data
public class Response<T> {
    private T response;
    private boolean isError;
    private String error;

    public Response() {}

    public Response(T response) {
        this.response = response;
        isError = false;
    }

    public Response(Exception exception) {
        this.isError = true;
        this.error = exception.getMessage();
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
