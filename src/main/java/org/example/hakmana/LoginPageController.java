package org.example.hakmana;

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

import java.io.IOException;

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
        if(getUsername().equals(tempUserName)){
            if(getPsswrd().equals(tempPsswrd)){
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
                System.out.println("Login successfull");
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
