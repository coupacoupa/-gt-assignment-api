package com.govtech.assignment.dto;

public class ErrorDto<T> {
    public T message;
    public int statusCode;

    public ErrorDto(T message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
