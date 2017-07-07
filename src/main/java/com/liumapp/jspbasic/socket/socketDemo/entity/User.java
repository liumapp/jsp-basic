package com.liumapp.jspbasic.socket.socketDemo.entity;

import java.io.Serializable;

/**
 * Created by liumapp on 7/6/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class User implements Serializable {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}