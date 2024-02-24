package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    Stage stage;
    Scene scene;
    Parent root;
    public void addUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();

    }


    public void desktop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("user.fxml"));
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();

    }



    }
