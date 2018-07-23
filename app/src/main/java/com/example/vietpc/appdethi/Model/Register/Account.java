package com.example.vietpc.appdethi.Model.Register;

public class Account {
    private String Name;
    private String Email;
    private String Password;

    public Account() { }

    public Account(String name, String email) {
        Name = name;
        Email = email; }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


}
