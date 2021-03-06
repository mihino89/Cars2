package com.groundZer0.autobazar.controller.admin;

import com.groundZer0.autobazar.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class SettingsController extends Controller {

    @FXML
    public AnchorPane settings_layout;

    /**
     * Change  screen function
     */
    public void go_user_management(){
        this.scene_switcher2(settings_layout, this.admin_user_management);
    }

    /**
     * Change  screen function
     */
    public void go_advertisment(){
        this.scene_switcher2(settings_layout, this.admin_advertisment_management);
    }

    /**
     * Logout function
     */
    public void do_logout(){
        this.logout(settings_layout);
    }
}
