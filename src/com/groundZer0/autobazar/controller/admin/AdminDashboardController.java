package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.Controller;
import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.data.users.User;
import com.groundZer0.autobazar.view.components.Alerts;

import com.groundZer0.autobazar.view.components.Dialog;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDashboardController extends Controller {
    private List<User> list_of_admin_users;
    private String alert_content;

    @FXML
    public ContextMenu context_menu;
    @FXML
    public MenuItem delete_user;
    @FXML
    public MenuItem add_user;
    @FXML
    public MenuItem edit_user;
    @FXML
    public TableColumn<User, String> table_name;
    @FXML
    public TableColumn<User, String> table_lastname;
    @FXML
    public TableColumn<User, String> table_phone;
    @FXML
    public TableColumn<User, String> table_birth;
    @FXML
    public TableColumn<User, String> table_email;
    @FXML
    public TableColumn<User, String> table_passwd;
    @FXML
    public TableColumn<User, String> table_role;
    @FXML
    public AnchorPane admin_dashboard_layout;
    @FXML
    public TableView<User> table_users;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        list_of_admin_users = AdminOps.getAdminOps().getList_of_admin_users();
        table_users.setItems(AdminOps.getAdminOps().getList_of_admin_users());

        /**
         * pouzitie eventHandlerov
         */
        delete_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user = table_users.getSelectionModel().getSelectedItem();
                delete_user(user);
            }
        });
        add_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                registration_dialog(admin_dashboard_layout, "admin");
            }
        });
        edit_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user = table_users.getSelectionModel().getSelectedItem();
                edit_user(user);
                System.out.println("want edit user");
//                registration_dialog(user_dashboard_layout, "admin");
            }
        });

        table_users.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table_users.getSelectionModel().selectFirst();
    }

    @Override
    public void init_alert() {
        this.alert_content = "Ste si isty, ze chcete vymazat uzivatela ";
    }

    private void delete_user(User user){
        init_alert();
        Alerts alert = new Alerts("INFORMATION");
        Optional<ButtonType> alert_answer = alert.show_alert("Vymazanie uzivatela", this.alert_content + user.getFirst_name() + "?");

        if(alert_answer.isPresent() && alert_answer.get() == ButtonType.OK){
            AdminOps.getAdminOps().remove_user_in_admin(user);
        }
    }

    private void edit_user(User user){

        Dialog edit_dialog = new Dialog(admin_dashboard_layout, "Editacia uzivatela",
                "Tento dialog sluzi na editaciu uzivatela", this.getModal_edit_admin, "edit_user_admin", user);
        edit_dialog.create_dialog();
    }

    public void do_logout(){
        this.logout(admin_dashboard_layout);
    }

    public void go_advertisment(){
        this.scene_switcher2(admin_dashboard_layout, this.admin_advertisment_management);
    }
}
