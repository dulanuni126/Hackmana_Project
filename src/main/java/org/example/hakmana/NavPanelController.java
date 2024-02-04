package org.example.hakmana;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NavPanelController extends VBox implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public NavPanelController() {
        super();
        FXMLLoader fxmlNavPanelController=new FXMLLoader(getClass().getResource("Nav_panel.fxml"));
        fxmlNavPanelController.setController(this);
        fxmlNavPanelController.setRoot(this);

        try {
            fxmlNavPanelController.load();
        }
        catch(IOException navPnlException){
            throw new RuntimeException(navPnlException);
        }

    }


}
