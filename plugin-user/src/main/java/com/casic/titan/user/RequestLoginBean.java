package com.casic.titan.user;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


/**
 * Create by CherishTang on 2019/10/18 0018
 * describe:
 */
public class RequestLoginBean extends BaseObservable {
    private String username;
    private String password;

    public RequestLoginBean() {
    }

    public RequestLoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RequestLoginBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
