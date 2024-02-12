package org.example.hakmana;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.CountedCompleter;

public class NavPanelController extends AnchorPane implements Initializable {
    @FXML
    private AnchorPane sidebar; // Reference to sidebar container
    @FXML
    private Button toggleButton; // Reference to toggle button
    private boolean isCollapsed = true;
    private double sidebarWidth;
    private TranslateTransition animationCollapse;

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;

    @FXML
    private VBox collapsedNavBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sidebarWidth = sidebar.getPrefWidth()-32;
    }
    public NavPanelController() {
        super();
        FXMLLoader fxmlNavPanelController=new FXMLLoader(getClass().getResource("Component/Nav_panel.fxml"));
        fxmlNavPanelController.setController(this);
        fxmlNavPanelController.setRoot(this);

        try {
            fxmlNavPanelController.load();
        }
        catch(IOException navPnlException){
            throw new RuntimeException(navPnlException);
        }

    }
    private void Animation(double animStartPos,double animEndPos){
        animationCollapse = new TranslateTransition(Duration.millis(300), sidebar);
        animationCollapse.setFromX(animStartPos);
        animationCollapse.setToX(animEndPos); // Hide sidebar initially
        animationCollapse.setAutoReverse(true);
        animationCollapse.play();
    }

    @FXML
    public void ToggleButton(ActionEvent event) {
        if(isCollapsed) {
            Animation(0,-sidebarWidth);
            vbox1.setVisible(false);
            vbox2.setVisible(false);
            vbox3.setVisible(false);
            collapsedNavBar.setVisible(true);
        }
        else{
            Animation(-sidebarWidth,0);
            collapsedNavBar.setVisible(false);
            vbox1.setVisible(true);
            vbox2.setVisible(true);
            vbox3.setVisible(true);
        }
        isCollapsed = !isCollapsed;
    }

}
