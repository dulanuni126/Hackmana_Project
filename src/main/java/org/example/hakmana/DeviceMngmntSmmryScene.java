package org.example.hakmana;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import org.example.hakmana.model.Desktop;
import org.example.hakmana.model.Devices;
import org.example.hakmana.model.Printer;

public class DeviceMngmntSmmryScene implements Initializable {

    @FXML
    private PathFinderController pathFinderController;
    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private HeaderController headerController;
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand

    @FXML
    private GridPane grid;
    private int rowCount = 1;
    private int colCount = 0;

    private String dbSelector;

    public String getDbSelector() {
        return dbSelector;
    }

    public void setDbSelector(String dbSelector) {
        this.dbSelector = dbSelector;
    }

    public void initialize(URL location, ResourceBundle resources) {
        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setPathTxt("Device Management>Desktop");
        pathFinderController.setBckBtnScene("Scene/DeviceMngmntSmmryScene.fxml");

        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                expand();
            } else {
                collapse();
            }
        });

    }

    @FXML
    public void addComponent() {
        System.out.println(dbSelector);

        //use polymhophism concept upcasting
        Devices[] dev=null;
        if(dbSelector.equals("Desktop")){
            dev=new Desktop().getDevices();
        }
        if(dbSelector.equals("Photocopy Machines")){
            dev=new Printer().getDevices();
        }
        if(dbSelector.equals("Monitors")){
            dev=new Desktop().getDevices();
        }
        if(dbSelector.equals("Projectors")){
            dev=new Desktop().getDevices();
        }
        if(dbSelector.equals("Laptops")){
            dev=new Desktop().getDevices();
        }

        DeviceInfoCardController card;
        for (Devices d : dev) {
            card=new DeviceInfoCardController();
            card.setUser(d.getUserName());
            card.setBrand(d.getModel());
            card.setDevId(d.getRegNum());

            // Add the label to the grid
            grid.add(card, colCount, rowCount);

            // Increment the row count for the next component
            colCount++;

            // If the row count is a multiple of 3, increment the column count
            if (colCount % 3 == 0) {
                rowCount++;
                colCount = 0;
            }
        }

    }

    public void addLastComponent() {
        AddDevButtonController addDevButtonController=new AddDevButtonController();


        // Add the label to the grid
        grid.add(addDevButtonController, colCount, rowCount);

        // Increment the row count for the next component
        colCount++;

        // If the row count is a multiple of 3, increment the column count
        if (colCount % 3 == 0) {
            rowCount++;
            colCount = 0;
        }

    }

    private void Animation(double animStartPos,double animEndPos){
        //Animation object refernce
        TranslateTransition bodyExpand = new TranslateTransition(Duration.millis(300), bodyComponet);
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
