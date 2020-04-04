package com.groundZer0.autobazar.controller;

import com.groundZer0.autobazar.view.components.Dialog;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.MalformedURLException;
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

    public void registration_dialog() throws MalformedURLException {
        Dialog registration_dialog = new Dialog(index_layout, "Registracia", "Tento dialog sluzi na registraciu noveho uzivatela", "registrationModal.fxml", "registration");
        registration_dialog.create_dialog();
    }
}
