package org.example.hakmana;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PathFinderController extends VBox implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public PathFinderController() {
        super();
        FXMLLoader fxmlPathLoader = new FXMLLoader(getClass().getResource("Component/PathFinder.fxml"));
        fxmlPathLoader.setController(this);
        fxmlPathLoader.setRoot(this);

        try{
            fxmlPathLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
