package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.datamodel.alerts.ErrorAlert;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Objects;

public class LoginController extends Controller{

    @FXML
    private AnchorPane login_layout;

    @FXML
    private TextField email;

    @FXML
    private PasswordField passwd;

    @FXML
    private Button to_index_button;

    @FXML
    private Label banner;

    ErrorAlert errorAlert = new ErrorAlert();

    public void initialize() {}

    public void authenticate(){
        if (Objects.equals("admin", email.getText()) && Objects.equals("admin", passwd.getText())) {
            System.out.println("success login");
//            this.scene_switcher(mainGridPane, "dashboard");
        } else {
            email.clear();
            passwd.clear();
            errorAlert.show_alert("Error pri prihaseni", "Zly email alebo heslo");
        }
    }

    public void go_index(){
        scene_switcher2(login_layout, "index");
    }
}
