package com.groundZer0.autobazar.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AdminDashboardController extends Controller{

    @FXML
    public AnchorPane user_dashboard_layout;

    public void do_logout(){
        this.logout(user_dashboard_layout);
    }
}
