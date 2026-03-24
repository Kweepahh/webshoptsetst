package org.example.zaalschoenenwebshop.dto;

public class LoginResponse {
    public String email;
    public String token;
    public boolean admin;

    public LoginResponse(String email, String token, boolean admin) {
        this.email = email;
        this.token = token;
        this.admin = admin;
    }
}