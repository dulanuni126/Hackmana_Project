package org.example.hakmana.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.hakmana.model.DatabaseConnection;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;

public class LoginPageController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private String username="udara";
    private String psswrd="0916";


    @FXML
    private TextField psswrdFeild,usrNameFeild;

    @FXML
    private Button login;

    public String getUsername() {
        return username;
    }

    public String getPsswrd() {
        return psswrd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPsswrd(String psswrd) {
        this.psswrd = psswrd;
    }
    public  void DashboardSceneLoad(ActionEvent event) throws IOException {
        String tempUserName=usrNameFeild.getText();
        String tempPsswrd=psswrdFeild.getText();
        if(true){//(getUsername().equals(tempUserName)){
            if(true){//(getPsswrd().equals(tempPsswrd)){
                String filePath = "src/main/resources/org/example/hakmana/Scene/dashboard.fxml";
                try {
                    Parent sceneRoot = FXMLLoader.load(new File(filePath).toURI().toURL());
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(sceneRoot);

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
                    System.out.println("Login successfull");

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }else{
                String text="You have entered Incorrect passowrd for "+tempUserName;
                alertBox(event,"Password Incorrect",text);
                System.out.println("Password error");
            }
        }else{
            String text="You have entered Incorrect username";
            alertBox(event,"Uername incorrect",text);
            System.out.println("Username error");
        }

    }

    static void alertBox(ActionEvent event,String title,String content){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
