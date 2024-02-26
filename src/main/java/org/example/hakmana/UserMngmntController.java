package org.example.hakmana;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.hakmana.HeaderController;
import org.example.hakmana.NavPanelController;
import org.example.hakmana.PathFinderController;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserMngmntController implements Initializable {

    @FXML
    private HeaderController headerController;
    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand
    @FXML
    private PathFinderController pathFinderController;
    private  TranslateTransition bodyExpand;//Animation object refernce
    @FXML
    private AnchorPane parentAnchor;

    public void initialize(URL location, ResourceBundle resources) {

        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("User management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setUserMngmntBorder();
        pathFinderController.setSearchBarVisible(false);
        pathFinderController.setPathTxt("User Management");
        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                expand();
            }else{
                collapse();
            }
        });
    }

    private void Animation(double animStartPos,double animEndPos){
        bodyExpand = new TranslateTransition(Duration.millis(300), bodyComponet);
        bodyExpand.setFromX(animStartPos);
        bodyExpand.setToX(animEndPos); // expand VBox
        bodyExpand.setAutoReverse(true);
        bodyExpand.play();

    }
    public  void expand() {
        Animation(0, -244);
        bodyComponet.setMinWidth(992);
        bodyComponet.setMinWidth(bodyComponet.getWidth()+244);
        //System.out.println(bodyComponet.getWidth()+244);
    }
    public  void collapse() {
        Animation(-244, 0);
        bodyComponet.setMinWidth(bodyComponet.getWidth()-244);
        bodyComponet.setMinWidth(748);
    }


    // Button action methods
    @FXML
    public void handleCreateAccountButtonAction(ActionEvent event) throws IOException{
        FXMLLoader createAccfxmlLoad = new FXMLLoader();
        createAccfxmlLoad.setLocation(getClass().getResource("Scene/CreateAccount.fxml"));
        DialogPane createAccDialogPane=createAccfxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(createAccDialogPane);
        dialog.setTitle("Create Account");

        Optional<ButtonType> clickedButton=dialog.showAndWait();
    }

    @FXML
    protected void handleEditProfileButtonAction(ActionEvent event)throws IOException {
        FXMLLoader editAccfxmlLoad = new FXMLLoader();
        editAccfxmlLoad.setLocation(getClass().getResource("Scene/EditProfile.fxml"));
        DialogPane editAccDialogPane=editAccfxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(editAccDialogPane);
        dialog.setTitle("Edit Account");

        Optional<ButtonType> clickedButton=dialog.showAndWait();
    }

    @FXML
    protected void handleShowUsersButtonAction(ActionEvent event)throws IOException {
        FXMLLoader showAccfxmlLoad = new FXMLLoader();
        showAccfxmlLoad.setLocation(getClass().getResource("Scene/ShowUsers.fxml"));
        DialogPane showAccDialogPane=showAccfxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(showAccDialogPane);
        dialog.setTitle("Show Users");

        Optional<ButtonType> clickedButton=dialog.showAndWait();
    }



}

