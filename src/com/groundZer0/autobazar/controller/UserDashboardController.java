package com.groundZer0.autobazar.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class UserDashboardController extends Controller {

    @FXML
    public Button logout;

    @FXML
    public AnchorPane user_dashboard_layout;

    /**
     * logout function
     */
    public void do_logout(){
        this.logout(user_dashboard_layout);
    }
}
