package com.groundZer0.autobazar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController extends Controller{

    @FXML
    private AnchorPane index_layout;

    @FXML
    private TextField search;

    @FXML
    private Button login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}

    public void do_login(){
        scene_switcher2(index_layout, "login");
    }
}
