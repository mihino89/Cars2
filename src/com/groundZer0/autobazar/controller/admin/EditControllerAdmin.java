package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.Controller;
import com.groundZer0.autobazar.controller.networking.Connection;
import com.groundZer0.autobazar.controller.networking.ConnectionProtectionProxy;
import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.view.components.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
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

    /**
     * editing validation
     * @param email_old
     */
    public void edit_init(String email_old) {
        this.email_old = email_old;

        email.setText(email_old);
    }

    /**
     * Editing user, password editing not applied
     * @param user
     */
    public void try_edit_user(User user){
        Connection connection = new ConnectionProtectionProxy();
        User new_user = user;

        String new_email = email.getText();
        String new_passwd = password.getText();
        String new_passwd_control = password_control.getText();

        if(!(Objects.equals(user.getEmail(), new_email)) && new_passwd.length() <= 0){

            /* Vymaze sa stary user */
            AdminOps.getAdminOps().remove_user_in_admin(user);

            /* zmenim email novemu */
            new_user.setEmail(new_email);

            if(new_user.getLast_name().equals("")){
                System.out.println("uzivatel nezadal priezvisko");
                new_user = new User(new_user.getFirst_name(), new_user.getPhone_number(), new_user.getBirth(),
                        new_user.getEmail(), new_user.getPassword(), new_user.getPrivilages(), this.operation_note_admin);
            } else {
                System.out.println("uzivatel zadal aj priezvisko");
                new_user = new User(new_user.getFirst_name(), new_user.getLast_name(), new_user.getPhone_number(),
                        new_user.getBirth(), new_user.getEmail(), new_user.getPassword(), new_user.getPrivilages(),
                        this.operation_note_admin);
            }

            /* add new user to users array */
            if(!connection.try_connect_with_server(new_user)){
                Alerts alerts = new Alerts("Error");
                alerts.show_alert("Registration fail", "Registracia nebola uspesna");
                return;
            }

            return;
        }

        if(Objects.equals(user.getEmail(), new_email) && new_passwd.length() > 0){
            System.out.println("Chcem editovat len heslo");
            return;
        }

        if(!(Objects.equals(user.getEmail(), new_email)) && new_passwd.length() > 0){
            System.out.println("Email was edited a heslo chcem editovat");
            return;
        }

        System.out.println("email was not edited " + new_email + " : " + user.getEmail());
    }
}
