package com.groundZer0.autobazar.datamodel.alerts.users;

import java.time.LocalDate;

public class User {
    /* Personal informations */
    private String first_name;
    private String last_name;
    private String phone_number;
    private LocalDate birth;

    /* Credentials */
    private String email;
    private String password;
    private boolean isAdmin;

    public User(String first_name, String last_name, String phone_number, LocalDate birth, String email, String password, boolean isAdmin) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String first_name, String phone_number, LocalDate birth, String email, String password, boolean isAdmin) {
        this.first_name = first_name;
        this.phone_number = phone_number;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String first_name, String phone_number, String s, LocalDate localDate, String password, String s1) {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

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

    public LocalDate getBirth() {
        return birth;
    }

    public String isAdmin() {
        if(isAdmin){
            return "true";
        }

        return "false";
    }
}
