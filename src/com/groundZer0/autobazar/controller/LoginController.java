package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.view.components.Alerts;
import com.groundZer0.autobazar.datamodel.users.User;
import com.groundZer0.autobazar.datamodel.users.UsersOps;
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

    Alerts alerts;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list_of_users = UsersOps.getUsersOps().getUsers();
    }

    public void authorization(String role){
        /* Set role in loggin to control user in future requests */
        this.setLogin_role(role);

        if(Objects.equals(role, "user")){
            this.scene_switcher2(login_layout, "userDashboard");
            return;
        }

        this.scene_switcher2(login_layout, "adminDashboard");
    }

    public void authentication(){
        for(User user : list_of_users){
            if (Objects.equals(user.getEmail(), email.getText().trim()) && Objects.equals(user.getPassword(), passwd.getText().trim())) {
                session_start(user);
                authorization(user.getPrivilages());
                return;
            }
        }

        email.clear();
        passwd.clear();
        alerts = new Alerts("ERROR");
        alerts.show_alert("Error pri prihaseni", "Zly email alebo heslo");
    }

    public void go_index(){
        scene_switcher2(login_layout, "index");
    }

    public void registration() {
        this.registration_dialog(login_layout);
    }
}
