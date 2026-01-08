package com.tripbyte.hotel.exception;

/**
 * @author Simpson Alfred
 */

public class InternalServerException extends RuntimeException {
    public InternalServerException(String message) {
        super(message);
    }
}