package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.view.components.Alerts;
import javafx.scene.control.PasswordField;

import java.util.Objects;

public class RegistrationController extends Controller {
    protected final String operation_note = "registration";
    protected final String operation_note_admin = "registration_admin";
    Alerts alerts;

    protected boolean validation(PasswordField passwd, PasswordField passwd_check){
        /* Validacia zhody hesiel */
        if(!Objects.equals(passwd.getText(), passwd_check.getText())){
            alerts = new Alerts("ERROR");
            alerts.show_alert("Error pri registracii", "Hesla sa nezhoduju");
            passwd.clear();
            passwd_check.clear();

            return false;
        }
        return true;
    }
}
