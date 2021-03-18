package com.epam.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR,reason = "Triangle is not exist")
public class TriangleCalculatorException extends Exception  {
    public TriangleCalculatorException() {
    }

    public TriangleCalculatorException(String message) {
        super(message);
    }

    public TriangleCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleCalculatorException(Throwable cause) {
        super(cause);
    }
}
