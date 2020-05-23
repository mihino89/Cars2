package com.groundZer0.autobazar.controller.user;

import com.groundZer0.autobazar.controller.RegistrationController;
import com.groundZer0.autobazar.controller.networking.Connection;
import com.groundZer0.autobazar.controller.networking.ConnectionProtectionProxy;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.interfaces.RegistrationI;
import com.groundZer0.autobazar.view.components.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class RegistrationControllerUser extends RegistrationController implements RegistrationI{
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

    /**
     * function to user registration
     */
    public void user_registration() {
        /* Validacia zhody hesiel */
        if(!validation(password, password_control)){
            return;
        }
        User new_user;
        Connection connection = new ConnectionProtectionProxy();

        String first_name_v = first_name.getText().trim();
        String last_name_v = last_name.getText().trim();
        String phone_number_v = phone_number.getText().trim();
        LocalDate birth_v = birth.getValue();

        String email_v = email.getText().trim();
        String password_v = password.getText();

        if(last_name_v.equals("")){
            System.out.println("uzivatel nezadal priezvisko");
            new_user = new User(first_name_v, phone_number_v, birth_v, email_v, password_v, "user", operation_note);
        } else {
            System.out.println("uzivatel zadal aj priezvisko");
            new_user = new User(first_name_v, last_name_v, phone_number_v, birth_v, email_v, password_v, "user", operation_note);
        }

        /* add new user to users array */
        if(!connection.try_connect_with_server(new_user)){
            Alerts alerts = new Alerts("Error");
            alerts.show_alert("Registration fail", "Registracia nebola uspesna");
        }
    }
}
