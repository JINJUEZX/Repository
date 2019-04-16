package com.example.lianxi0325.dto;

import javax.validation.constraints.Size;

public class UserRegisterDTO {

    @Size(min = 2,max = 12)
    private String username;

    @Size(min = 6,max = 20)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
