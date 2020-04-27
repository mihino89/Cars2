package com.groundZer0.autobazar.controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationControllerAdmin {
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
    private RadioButton RoleOptionUser;
    @FXML
    private RadioButton RoleOptionAdmin;

    public void handleChange() {
//        System.out.println("The checkbox is " + (RoleOptionUser.isSelected() ? "checked" : "not checked"));
    }
}
