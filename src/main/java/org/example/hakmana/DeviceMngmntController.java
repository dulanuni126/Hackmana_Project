package org.example.hakmana;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.net.URL;
import java.security.PrivilegedAction;
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


        addComponent("Desktop", new Image(getClass().getResourceAsStream("Scene/Images/Desktop.png")),"Scene/DeviceMngmntDevCard.fxml",false);
        addComponent("Photocopy Machines",new Image(getClass().getResourceAsStream("Scene/Images/photoCopy.png")),"Scene/DeviceMngmntDevCard.fxml",true);
        addComponent("Monitors",new Image(getClass().getResourceAsStream("Scene/Images/monitor.png")),"Scene/DeviceMngmntDevCard.fxml",true);
        addComponent("Projectors",new Image(getClass().getResourceAsStream("Scene/Images/projector.png")),"Scene/DeviceMngmntDevCard.fxml",true);
        addComponent("Laptops",new Image(getClass().getResourceAsStream("Scene/Images/laptopcat.png")),"Scene/DeviceMngmntDevCard.fxml",true);
        addComponent("Other Devices",new Image(getClass().getResourceAsStream("Scene/Images/other.png")),"Scene/DeviceMngmntDevCard.fxml",true);


    }

    @FXML
    private void addComponent(String catTitle, Image catImage,String scnelink,boolean stateVal) {
        // Create a new label
        DeviceCategoryCardController card=new DeviceCategoryCardController();
        card.setDevName(catTitle);
        card.setDeviceImage(catImage);
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
        //System.out.println(bodyComponet.getWidth()+244);
    }
    public  void collapse() {
        Animation(-244, 0);
        bodyComponet.setMinWidth(bodyComponet.getWidth()-244);
        bodyComponet.setMinWidth(748);
    }


}