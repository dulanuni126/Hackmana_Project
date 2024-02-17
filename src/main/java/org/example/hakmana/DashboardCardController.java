package org.example.hakmana;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardCardController extends ScrollPane implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
