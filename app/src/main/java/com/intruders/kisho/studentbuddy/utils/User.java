package com.intruders.kisho.studentbuddy.utils;

/**
 * Created by kisho on 26-08-2017.
 */

public class User {

    private String id,Username,Password,Email,Mobile;
    public User(String id,String Username,String Password,String Email,String Mobile){
        this.id=id;
        this.Username=Username;
        this.Password=Password;
        this.Email=Email;
        this.Mobile=Mobile;
    }
    public User(String username){
        this.Username=username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }
}
