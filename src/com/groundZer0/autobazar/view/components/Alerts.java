package com.groundZer0.autobazar.view.components;

import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

import java.util.Objects;
import java.util.Optional;

public class Alerts {
    javafx.scene.control.Alert alert;
    private String alert_type;

    public Alerts(String alert_type) {
        this.alert_type = alert_type;
    }


    public Optional<ButtonType> show_alert(String title, String content){
        if(Objects.equals(alert_type,"ERROR")){
            alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        } else if(Objects.equals(alert_type,"WARNING")){
            alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        } else {
            alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        }
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(title);
        alert.setContentText(content);

        return alert.showAndWait();
    }
}
