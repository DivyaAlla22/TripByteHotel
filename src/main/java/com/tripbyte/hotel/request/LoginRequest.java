package com.tripbyte.hotel.request;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Simpson Alfred
 */
public class LoginRequest {
    
    @NotBlank
    private String email;
    
    @NotBlank
    private String password;

    // MANUAL NO-ARGS CONSTRUCTOR (Required for Jackson/JSON mapping)
    public LoginRequest() {
    }

    // MANUAL ALL-ARGS CONSTRUCTOR (Optional, but helpful)
    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // --- MANUAL GETTERS AND SETTERS ---

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}