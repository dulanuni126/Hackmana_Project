package org.example.hakmana;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import org.example.hakmana.model.*;

import java.net.URL;
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

    //Device details
    @FXML
    private TextField FloppyDiskTextField;
    @FXML
    private TextField NetworkCardTextField;
    @FXML
    private TextField TVCardTextField;
    @FXML
    private TextField SoundCardTextField;
    @FXML
    private TextField OSTextField;
    @FXML
    private TextField StatusTextField;
    @FXML
    private TextField hardDiskTextField;
    @FXML
    private TextField keyboardRegNumTextField;
    @FXML
    private TextField micRegNumTextField;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField monitorRegNumTextField;
    @FXML
    private TextField mouseRegNumTextField;
    @FXML
    private TextField processorTextField;
    @FXML
    private TextField projectorRegNumTextField;
    @FXML
    private TextField purchasedFromTextField;
    @FXML
    private TextField ramTextField;
    @FXML
    private TextField regNumTextField;
    @FXML
    private TextField scannerRegNumTextField;
    @FXML
    private TextField serialNumTextField;
    @FXML
    private TextField speakerRegNumTextField;
    @FXML
    private TextField warrantyTextField;
    @FXML
    private AnchorPane parentAnchor;

    private String deviceSelector;
    private String devRegNum;
    private  TranslateTransition bodyExpand;//Animation object refernce

    public void initialize(URL location, ResourceBundle resources) {
        headerController.setFontSize("2.5em");
        headerController.setTitleMsg("Device Management");
        headerController.setUsernameMsg("Mr.Udara Mahanama");
        headerController.setDesignationMsg("Development Officer");
        navPanelController.setDeviceMngmntdBorder();
        pathFinderController.setSearchBarVisible(false);
        //pathFinderController.setBckBtnScene("Scene/DevDetailedView.fxml");

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

    public String getDevRegNum() {
        return devRegNum;
    }

    public void setDevRegNum(String devRegNum) {
        this.devRegNum = devRegNum;
    }

    public String getDeviceSelector() {
        return deviceSelector;
    }

    public void setDeviceSelector(String deviceSelector) {
        this.deviceSelector = deviceSelector;
    }

    public void showDeviceDetail(){
        //use polymorphism concept upcasting
        Devices dev=null;//dev store the Device
        if(deviceSelector.equals("Desktop")){
            dev=new Desktop().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Desktop>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("Photocopy Machines")){
            dev=new PhotocpyMchine().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Photocopy Machines>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("Monitors")){
            dev=new Monitors().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Monitors>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("Projectors")){
            dev=new Projectors().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Projectors>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("Laptops")){
            dev=new Laptops().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Laptops>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("Printers")){
            dev=new Printer().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>Printers>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
        if(deviceSelector.equals("UPS")){
            dev=new UPS().getDevice(getDevRegNum());
            pathFinderController.setPathTxt("Device Management>UPS>"+getDevRegNum());
            regNumTextField.setText(dev.getRegNum());
        }
    }


}
