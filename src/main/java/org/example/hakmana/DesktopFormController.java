package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DesktopFormController implements Initializable {
    Stage stage;
    Scene scene;
    Parent root;
    @FXML
    private ChoiceBox<String> FloppyDiskChoiseBox;

    @FXML
    private ChoiceBox<String> NetworkCardChoiseBox;

    @FXML
    private ChoiceBox<String> SoundCardChoiseBox;

    @FXML
    private ChoiceBox<String> StatusChoiseBox;

    @FXML
    private ChoiceBox<String> TVCardChoiseBox;
    @FXML
    private ChoiceBox<String> OSChoiseBox;
    private String[] deviceStatus={"Active","Repairing","Inactive"};
    private String[] YN={"Yes","No"};
    private String[] WinLin={"Windows","Linux"};
    private String[] OnboardDecicated={"On Board","Dedicated"};
    public void addUser(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene/user.fxml"));
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.show();

    }


    public void desktop(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Scene/desktop.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StatusChoiseBox.getItems().addAll(deviceStatus);
        FloppyDiskChoiseBox.getItems().addAll(YN);
        NetworkCardChoiseBox.getItems().addAll(OnboardDecicated);
        SoundCardChoiseBox.getItems().addAll(OnboardDecicated);
        TVCardChoiseBox.getItems().addAll(OnboardDecicated);
        OSChoiseBox.getItems().addAll(WinLin);
    }


}
