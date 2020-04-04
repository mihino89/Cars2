package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.view.components.ErrorAlert;
import com.groundZer0.autobazar.datamodel.alerts.users.User;
import com.groundZer0.autobazar.datamodel.alerts.users.UsersOps;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController extends Controller{
    private List<User> list_of_users;

    @FXML
    private AnchorPane login_layout;

    @FXML
    private TextField email;

    @FXML
    private PasswordField passwd;

    @FXML
    private Button to_index_button;

    @FXML
    private Button authenticate;

    @FXML
    private Label banner;

    ErrorAlert errorAlert = new ErrorAlert();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list_of_users = UsersOps.getUsersOps().getUsers();
    }

    public void authenticate(){
        for(User user : list_of_users){
            System.out.println("email: " + user.getEmail());
            if (Objects.equals(user.getEmail(), email.getText().trim()) && Objects.equals(user.getPassword(), passwd.getText().trim())) {
                System.out.println("success login");
                this.scene_switcher2(login_layout, "dashboard");
                return;
            }
        }

        email.clear();
        passwd.clear();
        errorAlert.show_alert("Error pri prihaseni", "Zly email alebo heslo");
    }

    public void go_index(){
        scene_switcher2(login_layout, "index");
    }

    public void registration() {
        this.registration_dialog(login_layout);
    }
}
