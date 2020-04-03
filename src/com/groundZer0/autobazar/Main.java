package com.groundZer0.autobazar;

import com.groundZer0.autobazar.datamodel.alerts.users.UsersOps;
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
        primaryStage.setScene(new Scene(root, 960, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init(){
        try{
            UsersOps.getUsersOps().users_loading();
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
