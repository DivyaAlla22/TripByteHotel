package com.tripbyte.hotel.exception;

/**
 * @author Simpson Alfred
 */

public class RoleAlreadyExistsException extends RuntimeException {
    public RoleAlreadyExistsException(String message) {
        super(message);
    }
}