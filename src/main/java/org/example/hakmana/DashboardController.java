package org.example.hakmana;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private HeaderController headerController;//header custom component injector
    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private FooterController footerController;
    @FXML
    private PathFinderController pathFinderController;
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand
    @FXML
    private Stage stage;
    @FXML
    private Button addDeviceBtn;
    private  TranslateTransition bodyExpand;//Animation object refernce

    @FXML
    private AnchorPane parentAnchor;

    public void initialize(URL location, ResourceBundle resources) {
        headerController.setFontSize("3em");
        headerController.setTitleMsg("Welcome");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDashboardBorder();
        pathFinderController.setSearchBarVisible(false);

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
        ///String cssRule = "-fx-min-width: 992px;";
        Double W1=bodyComponet.getWidth()+244;
        Animation(0, -244);
        bodyComponet.setMinWidth(W1);
        //bodyComponet.getStyleClass().add(cssRule);

    }
    public  void collapse() {
        Double W1=bodyComponet.getWidth()-244;
        Animation(-244, 0);
        bodyComponet.setMinWidth(W1);
    }
    public void addDeviceBtnDialogOpen(ActionEvent event) throws IOException {
        FXMLLoader addDevicefxmlLoad = new FXMLLoader();
        addDevicefxmlLoad.setLocation(getClass().getResource("Scene/DesktopForm.fxml"));
        DialogPane addDeviceDialogPane=addDevicefxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(addDeviceDialogPane);
        dialog.setTitle("Contact Us");

        Optional<ButtonType> clickedButton=dialog.showAndWait();

    }
}

