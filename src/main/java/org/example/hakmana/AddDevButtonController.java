package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddDevButtonController extends AnchorPane implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private AnchorPane root;

    public AddDevButtonController() {
        super();
        FXMLLoader fxmlFooterLoader = new FXMLLoader(getClass().getResource("Component/addDevButton.fxml"));
        fxmlFooterLoader.setController(this);
        fxmlFooterLoader.setRoot(this);

        try {
            fxmlFooterLoader.load();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }

    }
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
}
