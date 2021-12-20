package com.amity.parser.exceptions;

/**
 * Exception handling while parsing string
 */
public class ParserError extends RuntimeException {
    private int code;
    private String message;

    public ParserError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ParserError(String message, Throwable cause, int code) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

}
