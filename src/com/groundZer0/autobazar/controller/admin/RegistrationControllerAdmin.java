package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.RegistrationController;
import com.groundZer0.autobazar.controller.networking.Connection;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.view.components.Alerts;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

public class RegistrationControllerAdmin extends RegistrationController {
    private String selected_role = "user";

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
    @FXML
    private ToggleGroup rolesGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rolesGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton radioButton = (RadioButton)rolesGroup.getSelectedToggle();

                if (radioButton != null) {
                    if(Objects.equals(radioButton.getText(), "Admin")){
                        selected_role = "admin";
                    }
                    else if(Objects.equals(radioButton.getText(), "Uzivatel  ")){
                        selected_role = "user";
                    }
                    // change the label
                    System.out.println("selected_role: " + selected_role);
                }
            }
        });
    }

    public void user_registration() {

        if(!validation(password, password_control)){
            return;
        }
        User new_user;
        Connection connection = Connection.getConnection();

        String first_name_v = first_name.getText().trim();
        String last_name_v = last_name.getText().trim();
        String phone_number_v = phone_number.getText().trim();
        LocalDate birth_v = birth.getValue();

        String email_v = email.getText().trim();
        String password_v = password.getText();

        if(last_name_v.equals("")){
            System.out.println("uzivatel nezadal priezvisko");
            new_user = new User(first_name_v, phone_number_v, birth_v, email_v, password_v, this.selected_role, this.operation_note);
        } else {
            System.out.println("uzivatel zadal aj priezvisko");
            new_user = new User(first_name_v, last_name_v, phone_number_v, birth_v, email_v, password_v, this.selected_role, this.operation_note);
        }

        /* add new user to users array */
        if(!connection.try_connect_with_server(new_user)){
            Alerts alerts = new Alerts("Error");
            alerts.show_alert("Registration fail", "Registracia nebola uspesna");
        }
    }
}
