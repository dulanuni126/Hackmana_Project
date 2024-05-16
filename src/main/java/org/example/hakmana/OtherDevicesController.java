package org.example.hakmana;

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.hakmana.model.OtherDevices;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OtherDevicesController implements Initializable {
    private OtherDevices otherDevicesDb;
    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private HeaderController headerController;
    @FXML
    private VBox bodyComponet;//injector for VBox to expand
    @FXML
    private PathFinderController pathFinderController;

    @FXML
    private Button addNew;
    @FXML
    private Button ViewMore;

    @FXML
    private TableView<OtherDevices> otherDeviceTblView;
    @FXML
    private TableColumn<OtherDevices, Integer> num;
    @FXML
    private TableColumn<OtherDevices, String> deviceNameClmn;
    @FXML
    private TableColumn<OtherDevices, Integer> totalClmn;
    @FXML
    private TableColumn<OtherDevices, Integer> activeClmn;

    @FXML
    private TableColumn<OtherDevices, Integer> inactiveClmn;

    @FXML
    private TableColumn<OtherDevices, Integer> repairClmn;

    ObservableList<OtherDevices> observableOtherDevices;

    public void initialize(URL location, ResourceBundle resources) {
        otherDevicesDb=new OtherDevices();

        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setSearchBarVisible(false);
        pathFinderController.setPathTxt("Device Management");

        //create the event listener to the navigation panel ToggleButton() method
        navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                expand();
            } else {
                collapse();
            }
        });

        num.setCellValueFactory(new PropertyValueFactory<OtherDevices ,Integer>("num"));
        deviceNameClmn.setCellValueFactory(new PropertyValueFactory<OtherDevices ,String>("dev"));
        activeClmn.setCellValueFactory(new PropertyValueFactory<OtherDevices ,Integer>("numActiveDev"));
        inactiveClmn.setCellValueFactory(new PropertyValueFactory<OtherDevices ,Integer>("numInactiveDev"));
        repairClmn.setCellValueFactory(new PropertyValueFactory<OtherDevices ,Integer>("numRepairingDev"));
        totalClmn.setCellValueFactory(new PropertyValueFactory<OtherDevices ,Integer>("totalDev"));

        populateGridPane();
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

    public void populateGridPane() {
        new Thread(() -> {
            observableOtherDevices= FXCollections.observableArrayList();
            List<String> devices =otherDevicesDb.getDevices();
        try {
            int row = 1;  // Start adding devices from row 1 (after header row)
            for (String d : devices) {
                observableOtherDevices.addAll(new OtherDevices(row,d,0,0,0,0));
                row++;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        otherDeviceTblView.setItems(observableOtherDevices);
    }).start();
    }



}
