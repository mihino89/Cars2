package com.groundZer0.autobazar.view.components;

import com.groundZer0.autobazar.controller.admin.EditControllerAdmin;
import com.groundZer0.autobazar.controller.user.RegistrationControllerUser;
import com.groundZer0.autobazar.controller.admin.RegistrationControllerAdmin;

import com.groundZer0.autobazar.data.users.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

public class Dialog {
    private AnchorPane parent_of_dialog_pane;
    private String dialog_title;
    private String dialog_header;
    private String dialog_file_location;
    private String dialog_type;

    private User user;

    private final String base_location = "src/com/groundZer0/autobazar/view/";
    URL file_location;

    public Dialog(AnchorPane parent_of_dialog_pane, String dialog_title, String dialog_header, String dialog_file_location, String dialog_type) {
        this.parent_of_dialog_pane = parent_of_dialog_pane;
        this.dialog_title = dialog_title;
        this.dialog_header = dialog_header;
        this.dialog_file_location = dialog_file_location;
        this.dialog_type = dialog_type;

        try{
            file_location = Paths.get(base_location + dialog_file_location).toUri().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Dialog(AnchorPane parent_of_dialog_pane, String dialog_title, String dialog_header, String dialog_file_location, String dialog_type, User user) {
        this.parent_of_dialog_pane = parent_of_dialog_pane;
        this.dialog_title = dialog_title;
        this.dialog_header = dialog_header;
        this.dialog_file_location = dialog_file_location;
        this.dialog_type = dialog_type;
        this.user = user;

        try{
            file_location = Paths.get(base_location + dialog_file_location).toUri().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void create_dialog(){
        javafx.scene.control.Dialog<ButtonType> dialog = new javafx.scene.control.Dialog<>();
        dialog.initOwner(parent_of_dialog_pane.getScene().getWindow());
        dialog.setTitle(dialog_title);
        dialog.setHeaderText(dialog_header);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(file_location);

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch(IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        if(Objects.equals(this.dialog_type, "edit_user_admin")){
            EditControllerAdmin editControllerAdmin = fxmlLoader.getController();
            editControllerAdmin.edit_init(user.getEmail());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {

            if(Objects.equals(this.dialog_type, "registration")){
                RegistrationControllerUser registrationControllerUser = fxmlLoader.getController();
                registrationControllerUser.user_registration();
            }

            else if(Objects.equals(this.dialog_type, "registration_admin")){
                RegistrationControllerAdmin registrationControllerAdmin = fxmlLoader.getController();
                registrationControllerAdmin.user_registration();
            }

            else if(Objects.equals(this.dialog_type, "edit_user_admin")){
                EditControllerAdmin editControllerAdmin = fxmlLoader.getController();
                editControllerAdmin.try_edit_user(user);
//                RegistrationControllerAdmin registrationControllerAdmin = fxmlLoader.getController();
//                registrationControllerAdmin.user_registration();

                System.out.println("som admin a chcem editovat usera");
            }
        }
    }
}
