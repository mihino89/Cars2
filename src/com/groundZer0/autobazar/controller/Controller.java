package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.data.users.UserSession;
import com.groundZer0.autobazar.view.components.Alerts;
import com.groundZer0.autobazar.view.components.Dialog;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private String session_token = null;
    private String alert_content;

    protected final String admin_user_management = "adminDashboard/userManagement";
    protected final String admin_advertisment_management = "adminDashboard/advertismentManagement";
    protected final String admin_settings = "adminDashboard/settings";

    protected final String modal_registration = "modals/registrationModal.fxml";
    protected final String getModal_registration_admin = "modals/registrationModalAdmin.fxml";
    protected final String getModal_edit_admin = "modals/editModalAdmin.fxml";

    protected final String operation_note_admin = "registration_admin";

    private final String base_url = "src/com/groundZer0/autobazar/view/";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    /**
     * Polymorphism function main
     */
    public void init_alert(){
        this.alert_content = "404 Page not found";
    }

    /**
     * Helper function to get path
     * @param route
     * @return
     */
    private Path get_view_path(String route){
        return Paths.get(base_url + route + ".fxml");
    }

    /**
     * switching scene function
     * @param anchorPane
     * @param route
     */
    public void scene_switcher2(AnchorPane anchorPane, String route){
        try{
            anchorPane.getChildren().clear();

            URL url = get_view_path(route).toUri().toURL();
            anchorPane.getChildren().add(FXMLLoader.load(url));
        } catch (IOException e) {
            init_alert();
            Alerts alerts = new Alerts("ERROR");
            alerts.show_alert("Nieco sa porouchalo...", this.alert_content);
            e.printStackTrace();
        }
    }

    /**
     * registration dialog function
     * @param layout
     * @param role
     */
    public void registration_dialog(AnchorPane layout, String role) {
        Dialog registration_dialog = null;
        if(Objects.equals(role, "user")){
            registration_dialog = new Dialog(layout, "Registracia", "Tento dialog sluzi na registraciu noveho uzivatela", this.modal_registration, "registration");
        }
        else if(Objects.equals(role, "admin")){
            registration_dialog = new Dialog(layout, "Registracia", "Tento dialog sluzi na registraciu noveho uzivatela", this.getModal_registration_admin, "registration_admin");
        }
        registration_dialog.create_dialog();
    }

    /**
     * for checking session in application
     * TODO time to session and with parsing token check time
     * @return
     */
    protected boolean check_session(){
        return session_token != null;
    }

    /**
     * Main logout function to logout user
     * @param anchorPane
     */
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
