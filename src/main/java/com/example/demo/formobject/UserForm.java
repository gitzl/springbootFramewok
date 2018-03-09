package com.example.demo.formobject;

import javax.validation.constraints.Size;

/**
 * Created by king on 2018/3/9.
 */
public class UserForm {

    @Size(min = 6, max = 30)
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
