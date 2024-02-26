package org.example.hakmana;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.ResourceBundle;

public class DevDetailedViewController implements Initializable {

    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private HeaderController headerController;
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand
    @FXML
    private PathFinderController pathFinderController;
    @FXML
    private ScrollPane formPane;

    private  TranslateTransition bodyExpand;//Animation object refernce
    @FXML
    private AnchorPane parentAnchor;
    public void initialize(URL location, ResourceBundle resources) {

        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setSearchBarVisible(false);
        pathFinderController.setBckBtnScene("Scene/DevDetailedView.fxml");
        pathFinderController.setPathTxt("Device Management>Desktop>Detailed view");
        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                expand();
            }else{
                collapse();
            }
        });
        loadForm("Scene/DesktopDetails.fxml");
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
    private void loadForm(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            formPane.setContent(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
