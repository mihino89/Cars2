package com.groundZer0.autobazar.view.components;

import javafx.scene.control.Alert;
import javafx.stage.Modality;

public class ErrorAlert {

    public void show_alert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
