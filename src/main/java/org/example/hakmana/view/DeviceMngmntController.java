package org.example.hakmana.view;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.hakmana.componentControllers.DeviceCategoryCardController;
import org.example.hakmana.componentControllers.HeaderController;
import org.example.hakmana.componentControllers.NavPanelController;
import org.example.hakmana.componentControllers.PathFinderController;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceMngmntController implements Initializable {

    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private HeaderController headerController;
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand
    @FXML
    private PathFinderController pathFinderController;
    @FXML
    private AnchorPane parentAnchor;

    @FXML
    private GridPane grid;
    private int rowCount = 1;
    private int colCount = 0;
    private  TranslateTransition bodyExpand;//Animation object refernce


    public void initialize(URL location, ResourceBundle resources) {
        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setSearchBarVisible(false);
        pathFinderController.setPathTxt("Device Management");

        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                expand();
            }else{
                collapse();
            }
        });


        addComponent("Desktop", new File("src/main/resources/org/example/hakmana/Scene/Images/Desktop.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
        addComponent("Photocopy Machines",new File("src/main/resources/org/example/hakmana/Scene/Images/photoCopy.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
        addComponent("Monitors",new File("src/main/resources/org/example/hakmana/Scene/Images/monitor.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
        addComponent("Projectors",new File("src/main/resources/org/example/hakmana/Scene/Images/projector.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
        addComponent("Laptops",new File("src/main/resources/org/example/hakmana/Scene/Images/laptopcat.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
        addComponent("Other Devices",new File("src/main/resources/org/example/hakmana/Scene/Images/other.png"),"src/main/resources/org/example/hakmana/Scene/DeviceMngmntSmmryScene.fxml",false);
    }

    @FXML
    private void addComponent(String catTitle, File imageFile,String scnelink,boolean stateVal) {
        // Create a new label
        DeviceCategoryCardController card=new DeviceCategoryCardController();
        card.setDevName(catTitle);
        try {
            card.setDeviceImage(new Image(String.valueOf(imageFile.toURI().toURL())));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        card.setDevCatSceneName(scnelink);
        card.disableBtn(stateVal);

        // Add the label to the grid
        grid.add(card, colCount, rowCount);

        // Increment the row count for the next component
        colCount++;

        // If the row count is a multiple of 3, increment the column count
        if (colCount % 4 == 0) {
            rowCount++;
            colCount = 0;
        }

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
    }
    public  void collapse() {
        Animation(-244, 0);
        bodyComponet.setMinWidth(bodyComponet.getWidth()-244);
        bodyComponet.setMinWidth(748);
    }


}