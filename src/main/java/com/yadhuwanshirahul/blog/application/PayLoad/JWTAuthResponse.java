package com.yadhuwanshirahul.blog.application.PayLoad;

import lombok.Data;

@Data
public class JWTAuthResponse {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
