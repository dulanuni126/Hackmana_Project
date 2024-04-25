package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceCategoryCardController extends AnchorPane implements Initializable{

    //For change the scene when press the button
    private Stage stage;
    private Scene scene;
    private Parent sceneRoot;

    //Injector for anchorpane For animation
    @FXML
    private AnchorPane root;

    //Injectors for button and the image
    @FXML
    private Button devInfoBtn;
    @FXML
    private ImageView devImage;

    //private variable to set iamge and the device naem
    private Image deviceImage;
    private String devName;
    private String devCatSceneName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public DeviceCategoryCardController() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Component/DeviceCategoryCard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

//    For animation of the cards
    @FXML
    private void onMouseEntered() {
        root.setScaleX(1.1);
        root.setScaleY(1.1);
    }
    @FXML
    private void onMouseExited() {
        root.setScaleX(1.0);
        root.setScaleY(1.0);
    }


    public Image getDeviceImage() {
        return deviceImage;
    }
    public void setDeviceImage(Image deviceImage) {
        this.deviceImage = deviceImage;
        devImage.setImage(deviceImage);
    }
    public String getDevName() {
        return devName;
    }
    public void setDevName(String devName) {
        this.devName = devName;
        devInfoBtn.setText(this.devName);
    }
    public String getDevCatSceneName() {
        return devCatSceneName;
    }
    public void setDevCatSceneName(String devCatSceneName) {
        this.devCatSceneName = devCatSceneName;
    }
    public void disableBtn(boolean stateVal){
        devInfoBtn.setDisable(stateVal);
    }

    public void DevInfoCall(ActionEvent event) throws IOException {
        if(devCatSceneName.equals("Scene/OtherDevices.fxml")){
            sceneRoot = FXMLLoader.load(getClass().getResource(devCatSceneName));
        }else {
            String selectedDeviceName = getDevName();  // Get the selected device name

            // Load the FXML loader for the target scene
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(devCatSceneName));

            //Using Setter Method
            DeviceMngmntSmmryScene controller = new DeviceMngmntSmmryScene();  // Create controller instance
            fxmlLoader.setController(controller);  // Set controller to the loader

            sceneRoot = fxmlLoader.load();  // Load the scene

            //After loading, set device name using setter
            controller.setDbSelector(selectedDeviceName);
            //System.out.println(controller.getDbSelector());
            controller.addComponent();
            controller.addLastComponent();
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(sceneRoot);
        stage.setScene(scene);
        stage.show();
    }


}

