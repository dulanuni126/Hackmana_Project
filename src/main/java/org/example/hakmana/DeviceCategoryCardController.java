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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceCategoryCardController extends AnchorPane implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button desktopBtn;
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

    public void DeiveInfoCall(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene/DeviceMngmntDevCard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

