package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.datamodel.cars.Vehicle;
import com.groundZer0.autobazar.datamodel.cars.VehicleOps;
import com.groundZer0.autobazar.datamodel.users.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController extends Controller{

    @FXML
    private AnchorPane index_layout;

    @FXML
    private ListView<Vehicle> list_of_vehicles;

    @FXML
    private Label headline;

    @FXML
    private Label vehicle_brand;

    @FXML
    private Label vehicle_model;

    @FXML
    private Label vehicle_description;

    @FXML
    private Label owner;

    @FXML
    private Label owner_email;

    @FXML
    private Label owner_phone;

    @FXML
    private Label vehicle_price;

    @FXML
    private TextField search;

    @FXML
    private Button login;

//    private User find_owner_of_vehicle(){
//
//    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        list_of_vehicles.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Vehicle>() {
            @Override
            public void changed(ObservableValue<? extends Vehicle> observableValue, Vehicle vehicle, Vehicle t1) {
                if(t1 != null){
                    Vehicle vehicle1 = list_of_vehicles.getSelectionModel().getSelectedItem();
                    headline.setText(vehicle1.getHeadline());
                    vehicle_brand.setText(vehicle1.getBrand());
                    vehicle_model.setText(vehicle1.getModel());
                    vehicle_description.setText(vehicle1.getDescription());
                    vehicle_price.setText(String.valueOf(vehicle1.getPrice()));
                    owner.setText(vehicle1.getOwner());
                }
            }
        });

        list_of_vehicles.setItems(VehicleOps.getVehicleOps().getList_of_vehicles());
        list_of_vehicles.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        list_of_vehicles.getSelectionModel().selectFirst();
    }

    public void do_login(){
        scene_switcher2(index_layout, "login");
    }

    public void registration() {
        this.registration_dialog(index_layout);
    }
}
