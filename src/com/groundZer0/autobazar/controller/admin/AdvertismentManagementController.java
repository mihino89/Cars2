package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.Controller;
import com.groundZer0.autobazar.data.cars.Vehicle;
import com.groundZer0.autobazar.data.cars.VehicleOps;
import com.groundZer0.autobazar.data.users.AdminOps;
import com.groundZer0.autobazar.view.components.Alerts;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdvertismentManagementController extends Controller {
    private String alert_content;

    @FXML
    public MenuItem delete_advertisement;
    @FXML
    public TableView<Vehicle> advertisment_cars;
    @FXML
    public AnchorPane advertisment_management_layout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        advertisment_cars.setItems(VehicleOps.getVehicleOps().getList_of_vehicles());

        delete_advertisement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Vehicle vehicle = advertisment_cars.getSelectionModel().getSelectedItem();
                delete_vehicle(vehicle);
            }
        });
    }

    @Override
    public void init_alert() {
        this.alert_content = "Ste si isty, ze chcete vymazat inzerat ";
    }

    private void delete_vehicle(Vehicle vehicle){
        init_alert();
        Alerts alert = new Alerts("INFORMATION");
        Optional<ButtonType> alert_answer = alert.show_alert("Vymazanie inzeratu ", this.alert_content + vehicle.getBrand() + "?");

        if(alert_answer.isPresent() && alert_answer.get() == ButtonType.OK){
            VehicleOps.getVehicleOps().remove_vehicle(vehicle);
        }
    }

    public void go_user_management(){
        this.scene_switcher2(advertisment_management_layout, this.admin_user_management);
    }

    public void do_logout(){
        this.logout(advertisment_management_layout);
    }
}
