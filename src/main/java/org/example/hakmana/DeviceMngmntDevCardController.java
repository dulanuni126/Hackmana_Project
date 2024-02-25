package org.example.hakmana;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.ResourceBundle;
import org.example.hakmana.DeviceInfoCardController;
import org.example.hakmana.model.DatabaseConnection;
import org.example.hakmana.model.Desktop;

public class DeviceMngmntDevCardController implements Initializable{

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

    private  TranslateTransition bodyExpand;//Animation object refernce

    @FXML
    private AnchorPane parentAnchor;
    public void initialize(URL location, ResourceBundle resources) {

        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setPathTxt("Device Management>Desktop");
        pathFinderController.setBckBtnScene("Scene/DeviceMngmntDevCard.fxml");

        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) ->{
            if(newValue){
                expand();
            }else{
                collapse();
            }
        });
        addComponent();
        addLastComponent();
    }
    @FXML
    private void addComponent() {
        DatabaseConnection databaseConnection=DatabaseConnection.getInstance();
        Desktop[] desktops =databaseConnection.getDesktops();

        DeviceInfoCardController card;
        for (Desktop desktop : desktops) {
            card=new DeviceInfoCardController();
            card.setUser(desktop.getUserName());
            card.setBrand(desktop.getModel());
            card.setDevId(desktop.getRegNum());

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
    private void addLastComponent() {
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
