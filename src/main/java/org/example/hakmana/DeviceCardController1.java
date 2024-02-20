package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceCardController1 extends AnchorPane implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public DeviceCardController1() {
        super();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Component/DeviceCard1.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    @FXML
    private Text DevText;
    @FXML
    private ImageView devImage;
    private Image deviceImage;

    public Image getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(Image deviceImage) {
        this.deviceImage = deviceImage;
        devImage.setImage(deviceImage);
    }

    private String devName;

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
        DevText.setText(this.devName);
    }
}
