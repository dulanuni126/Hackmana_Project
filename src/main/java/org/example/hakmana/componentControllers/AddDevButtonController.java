package org.example.hakmana.componentControllers;

//***********************************************************************************
//              controller for fxml file which is for add new device button
//***********************************************************************************

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AddDevButtonController extends AnchorPane implements Initializable {

    @FXML
    private Button addDeviceBtn;
    @FXML
    private AnchorPane root;

    //methods for component initialize and constructor for component load----------------------------
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
    public AddDevButtonController() {
        super();
        String filePath = "src/main/resources/org/example/hakmana/Component/addDevButton.fxml";
        FXMLLoader fxmlFooterLoader = null;
        try {
            fxmlFooterLoader = new FXMLLoader(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        fxmlFooterLoader.setController(this);
        fxmlFooterLoader.setRoot(this);

        try {
            fxmlFooterLoader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    //methods for animation----------------------------------------------------
    @FXML
    private void onMouseEntered() {//scale up when mouse enter
        root.setScaleX(1.1);
        root.setScaleY(1.1);
    }
    @FXML
    private void onMouseExited() {//scale up when mouse enter
        root.setScaleX(1.0);
        root.setScaleY(1.0);
    }

    //Open new device adding dialog pane----------------------------------------------------
    public void addDeviceBtnDialogOpen(ActionEvent event) throws IOException {
        String filePath = "src/main/resources/org/example/hakmana/Scene/DialogBoxView/DesktopForm.fxml";
        FXMLLoader addDevicefxmlLoad = null;
        try {
            addDevicefxmlLoad = new FXMLLoader(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        DialogPane addDeviceDialogPane=addDevicefxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(addDeviceDialogPane);
        dialog.setTitle("Add new device");

        Optional<ButtonType> clickedButton=dialog.showAndWait();

    }
}
