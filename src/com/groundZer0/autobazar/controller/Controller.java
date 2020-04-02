package com.groundZer0.autobazar.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    protected void scene_switcher1(ActionEvent event) throws IOException {
        System.out.println("You clicked me!");
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    public void scene_switcher2(AnchorPane anchorPane, String route){
//        AnchorPane pane = FXMLLoader.load(getClass().getResource("../view/login.fxml"));
        try{
            anchorPane.getChildren().clear();
            anchorPane.getChildren().add(FXMLLoader.load(getClass().getResource("../view/" + route + ".fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private HashMap<String, Pane> screenMap = new HashMap<>();
//    private Scene main;
//
//    public Controller(Scene main) {
//        this.main = main;
//    }
//
//    protected void addScreen(String name, Pane pane){
//        screenMap.put(name, pane);
//    }

//    protected void removeScreen(String name){
//        screenMap.remove(name);
//    }
//
//    protected void activate(String name){
//        main.setRoot( screenMap.get(name) );
//    }
}
