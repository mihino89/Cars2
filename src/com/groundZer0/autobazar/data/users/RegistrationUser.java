package com.groundZer0.autobazar.data.users;

import java.io.Serializable;
import java.time.LocalDate;

public class RegistrationUser implements Serializable {
    /* Personal informations */
    private String first_name;
    private String last_name;
    private String phone_number;

    static final long serialVersionUID = 42L;
    private LocalDate birth;

    /* Credentials */
    private String email;
    private String password;
    private String privilages;

    /* Security */
    private byte[] public_key;
    private String token;

    /* Operationals */
    private String operation_note;

    /* Registration constructor */
    public RegistrationUser(String first_name, String last_name, String phone_number, LocalDate birth, String email, String password, String privilages, String operation_note) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.privilages = privilages;
        this.operation_note = operation_note;
    }

    /* Registration constructor */
    public RegistrationUser(String first_name, String phone_number, LocalDate birth, String email, String password, String privilages, String operation_note) {
        this.first_name = first_name;
        this.phone_number = phone_number;
        this.birth = birth;
        this.email = email;
        this.password = password;
        this.privilages = privilages;
        this.operation_note = operation_note;
    }
}
