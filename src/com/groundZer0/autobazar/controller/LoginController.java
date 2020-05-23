package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.controller.networking.ConnectionProtectionProxy;
import com.groundZer0.autobazar.data.users.UserSession;
import com.groundZer0.autobazar.controller.networking.Connection;
import com.groundZer0.autobazar.view.components.Alerts;
import com.groundZer0.autobazar.data.users.User;
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
    private final String operation_note = "login_credentials";
    private List<User> user_session;
    private String alert_content;

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
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    /**
     * authorisation process in login
     */
    public void authorization(){
        user_session = UserSession.getUserSession().getUsers();

        for(User user : user_session){
            if(Objects.equals(user.getPrivilages(), "admin")){
                this.scene_switcher2(login_layout, this.admin_user_management);
                return;
            }
        }

        this.scene_switcher2(login_layout, "userDashboard");
    }

    /**
     * polymorphism function to set alert content
     */
    @Override
    public void init_alert() {
        this.alert_content = "Zly email alebo heslo";
    }

    /**
     * authentication process with server credential validation
     */
    public void authentication(){
        Connection connection = new ConnectionProtectionProxy();

        User auth_user = new User(email.getText().trim(), passwd.getText().trim(), this.operation_note);

        if(!connection.try_connect_with_server(auth_user)){
            email.clear();
            passwd.clear();
            init_alert();
            Alerts alerts = new Alerts("ERROR");
            alerts.show_alert("Error pri prihaseni", this.alert_content);
        } else {
            /* Login was successful */
            System.out.println("login successful from login controller");
            authorization();
        }
    }

    /**
     * change screen function
     */
    public void go_index(){
        scene_switcher2(login_layout, "index");
    }

    /**
     * change screen function
     */
    public void registration() {
        this.registration_dialog(login_layout, "user");
    }
}
