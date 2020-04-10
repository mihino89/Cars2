package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.data.users.UserSession;
import com.groundZer0.autobazar.view.components.Dialog;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private String session_token = null;

    private final String base_url = "src/com/groundZer0/autobazar/view/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        logged_user = null;
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

    protected boolean check_session(){
        return session_token != null;
    }

    public void logout(AnchorPane anchorPane){
        /* Premazat pole v UsersOPS */
        /* Skontroluj ci user nie je admin - ak je vymaz aj list v AdminOps*/
        AdminOps adminOps = AdminOps.getAdminOps();

        UserSession.getUserSession().remove_all_users();
        if(adminOps.getList_of_admin_users().size() > 0){
            adminOps.remove_all_users_in_admin();
        }
        scene_switcher2(anchorPane, "index");
    }
}
