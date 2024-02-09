package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HeaderController extends HBox implements Initializable {
    @FXML
    private Text headerTitle;
    private String message;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public HeaderController() {
        super();
        FXMLLoader fxmlHeaderLoader = new FXMLLoader(getClass().getResource("Component/Header.fxml"));
        fxmlHeaderLoader.setController(this);
        fxmlHeaderLoader.setRoot(this);

        try{
            fxmlHeaderLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        headerTitle.setText(this.message);
    }
}
