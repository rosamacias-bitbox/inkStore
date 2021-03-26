package com.store.warehouse.management.security;

public class AuthenticationResponse {

    private String token;

    private boolean ok;

    private String message;

    public AuthenticationResponse(String token) {
        this.token = token;
        this.ok = true;
    }

    public String getJwt() {
        return token;
    }
}
