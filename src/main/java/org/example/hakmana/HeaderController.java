package org.example.hakmana;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController extends HBox implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public HeaderController() {
        super();
        FXMLLoader fxmlHeaderLoader = new FXMLLoader(getClass().getResource("Header.fxml"));
        fxmlHeaderLoader.setController(this);
        fxmlHeaderLoader.setRoot(this);

        try{
            fxmlHeaderLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
