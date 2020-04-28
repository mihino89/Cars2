package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.Controller;
import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.data.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class EditControllerAdmin extends Controller {

    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password_control;

    private String email_old;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        email.setText(this.email_old);
    }

    public void edit_init(String email_old) {
        this.email_old = email_old;

        email.setText(email_old);
    }

    public void try_edit_user(User user){
        List<User> list_of_admin_users = AdminOps.getAdminOps().getList_of_admin_users();

        String new_email = email.getText();
        String new_passwd = password.getText();
        String new_passwd_control = password_control.getText();

        if(!(Objects.equals(user.getEmail(), new_email)) && new_passwd.length() <= 0){
            System.out.println("Email was edited a heslo nechcem editovat");
            return;
        }
        // TODO validacia na password
        if(Objects.equals(user.getEmail(), new_email) && new_passwd.length() > 0){
            System.out.println("Chcem editovat len heslo");
            return;
        }
        if(!(Objects.equals(user.getEmail(), new_email)) && new_passwd.length() > 0){
            System.out.println("Email was edited a heslo chcem editovat");
            return;
        }
        System.out.println("email wasnt edite " + new_email + " : " + user.getEmail());
    }
}
