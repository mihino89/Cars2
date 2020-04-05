package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.view.components.Alerts;
import com.groundZer0.autobazar.datamodel.users.User;
import com.groundZer0.autobazar.datamodel.users.UsersOps;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Objects;

public class RegistrationController {

    @FXML
    private TextField first_name;

    @FXML
    private TextField last_name;

    @FXML
    private TextField phone_number;

    @FXML
    private DatePicker birth;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField password_control;

    Alerts alerts;

    public void user_registration() {
        User new_user;

        /* Validacia zhody hesiel */
        if(!Objects.equals(password.getText(), password_control.getText())){
            alerts = new Alerts("ERROR");
            alerts.show_alert("Error pri registracii", "Hesla sa nezhoduju");
            password.clear();
            password_control.clear();

            return;
        }

        String first_name_v = first_name.getText().trim();
        String last_name_v = last_name.getText().trim();
        String phone_number_v = phone_number.getText().trim();
        LocalDate birth_v = birth.getValue();

        String email_v = email.getText().trim();
        String password_v = password.getText();

        if(last_name_v.equals("")){
            System.out.println("uzivatel nezadal priezvisko");
            new_user = new User(first_name_v, phone_number_v, birth_v, email_v, password_v, "user");
        } else {
            System.out.println("uzivatel zadal aj priezvisko");
            new_user = new User(first_name_v, last_name_v, phone_number_v, birth_v, email_v, password_v, "user");
        }

        /* add new user to users array */
        UsersOps.getUsersOps().add_user(new_user);
    }
}
