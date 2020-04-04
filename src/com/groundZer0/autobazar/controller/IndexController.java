package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.datamodel.cars.Vehicle;
import com.groundZer0.autobazar.datamodel.cars.VehicleOps;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class IndexController extends Controller{

    @FXML
    private AnchorPane index_layout;

    @FXML
    private ListView<Vehicle> list_of_vehicles;

    @FXML
    private TextField search;

    @FXML
    private Button login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
