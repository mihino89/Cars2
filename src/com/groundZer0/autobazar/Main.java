package com.groundZer0.autobazar;

import com.groundZer0.autobazar.datamodel.cars.VehicleOps;
import com.groundZer0.autobazar.datamodel.users.UsersOps;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./view/index.fxml"));
        primaryStage.setTitle("Hello World");
        Scene scene = new Scene(root, 960, 600);
        scene.getStylesheets().add("com/groundZer0/autobazar/view/assets/css/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init(){
        UsersOps.getUsersOps().users_loading();
        VehicleOps.getVehicleOps().cars_loading();
    }

    @Override
    public void stop() {
        try{
            UsersOps.getUsersOps().users_saving();
            VehicleOps.getVehicleOps().cars_saving();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
