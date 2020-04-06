package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.datamodel.users.User;
import com.groundZer0.autobazar.datamodel.users.UsersOps;
import com.groundZer0.autobazar.view.components.Alerts;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDashboardController extends Controller{
    private ObservableList<User> list_of_users;

    @FXML
    public ContextMenu context_menu;

    @FXML
    public MenuItem delete_user;

//    @FXML
//    public TableColumn<User, String> table_name;
//
//    @FXML
//    public TableColumn<User, String> table_lastname;
//
//    @FXML
//    public TableColumn<User, String> table_phone;
//
//    @FXML
//    public TableColumn<User, String> table_birth;
//
//    @FXML
//    public TableColumn<User, String> table_email;
//
//    @FXML
//    public TableColumn<User, String> table_passwd;
//
//    @FXML
//    public TableColumn<User, String> table_role;

    @FXML
    public AnchorPane user_dashboard_layout;

    @FXML
    public TableView<User> table_users;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list_of_users = UsersOps.getUsersOps().getUsers();
        table_users.setItems(list_of_users);

        delete_user.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user = table_users.getSelectionModel().getSelectedItem();
                delete_user(user);
            }
        });

//        table_users.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() {
//            @Override
//            public void changed(ObservableValue<? extends User> observableValue, User user, User t1) {
//                if(t1 != null){
//                    User user1 = table_users.getSelectionModel().getSelectedItem();
//                    table_name.setText(user1.getFirst_name());
//                    table_lastname.setText(user1.getLast_name());
//                }
//            }
//        });
//        table_users.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//        table_users.getSelectionModel().selectFirst();
    }

    private void delete_user(User user){
        Alerts alert = new Alerts("INFORMATION");
        Optional<ButtonType> alert_answer = alert.show_alert("Vymazanie uzivatela", "Ste si isty, ze chcete vymazat uzivatela " + user.getFirst_name());
        System.out.println(user.getFirst_name());

        if(alert_answer.isPresent() && alert_answer.get() == ButtonType.OK){
            UsersOps.getUsersOps().remove_user(user);
        }
    }

    public void do_logout(){
        this.logout(user_dashboard_layout);
    }
}
