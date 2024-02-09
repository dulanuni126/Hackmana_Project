package org.example.hakmana;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BodyPaneController extends AnchorPane implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public BodyPaneController() {
        super();
        FXMLLoader fxmlBodyPaneLoader = new FXMLLoader(getClass().getResource("Component/BodyPane.fxml"));
        fxmlBodyPaneLoader.setController(this);
        fxmlBodyPaneLoader.setRoot(this);

        try{
            fxmlBodyPaneLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
