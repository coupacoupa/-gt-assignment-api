package com.govtech.assignment.dto;

public class ResponseDto<T> {
    public T data;
    public int statusCode;

    public ResponseDto(T data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }
}
