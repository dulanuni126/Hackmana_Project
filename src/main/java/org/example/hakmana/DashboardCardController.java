package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardCardController extends ScrollPane implements Initializable {



    @FXML
    private Label topLabel;
    private String text;

    public DashboardCardController() {
        super();
        FXMLLoader fxmlDashboardCardLoader=new FXMLLoader(getClass().getResource("Component/dashboardCard.fxml"));

        fxmlDashboardCardLoader.setController(this);
        fxmlDashboardCardLoader.setRoot(this);


        try {
            fxmlDashboardCardLoader.load();

        }
        catch(IOException navPnlException){
            throw new RuntimeException(navPnlException);
        }
    }



    public void setText(String text) {
        this.text = text;
        topLabel.setText(this.text);
    }
    public String getText() {
        return topLabel.getText();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
