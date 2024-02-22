package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button login;


    public  void DashboardSceneLoad(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene/dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        //System.out.println(stage.getHeight());
        //System.out.println(stage.getHeight());
        // Get primary screen dimensions
        Screen screen = Screen.getPrimary();
        double width = screen.getBounds().getWidth();
        double height = screen.getBounds().getHeight();

        // Set stage size to match screen dimensions
        stage.setWidth(width);
        stage.setHeight(height);
        //stage.setResizable(true);
        //stage.setMaximized(true);

        stage.setX(0.0);
        stage.setY(0.0);
        stage.setScene(scene);
        stage.show();
    }
}
