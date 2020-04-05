package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.datamodel.security.UserSession;
import com.groundZer0.autobazar.datamodel.users.User;
import com.groundZer0.autobazar.datamodel.users.UsersOps;
import com.groundZer0.autobazar.view.components.Dialog;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private List<User> list_of_users;
    private String login_role;
    private UserSession userSession;
    private String session_token = null;

    private final String base_url = "src/com/groundZer0/autobazar/view/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list_of_users = UsersOps.getUsersOps().getUsers();
    }


    public void scene_switcher2(AnchorPane anchorPane, String route){
        try{
            anchorPane.getChildren().clear();

            URL url = Paths.get(base_url + route + ".fxml").toUri().toURL();
            anchorPane.getChildren().add(FXMLLoader.load(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registration_dialog(AnchorPane layout) {
        try {
            Dialog registration_dialog = new Dialog(layout, "Registracia", "Tento dialog sluzi na registraciu noveho uzivatela", "registrationModal.fxml", "registration");
            registration_dialog.create_dialog();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    protected void session_start(User user) {
        Date session_start_time = new Date(System.currentTimeMillis());
        userSession = UserSession.getInstance(session_start_time);
        session_token = userSession.encrypt(user.getPassword(), userSession.getPublicKey());
    }

    protected boolean check_session(){
        return session_token != null;
    }

    protected void session_closed(){
        userSession = null;
    }

    public void setLogin_role(String login_role) {
        this.login_role = login_role;
    }

    public void logout(AnchorPane anchorPane){
        session_closed();
        scene_switcher2(anchorPane, "index");
    }
}
