package org.example.hakmana;

import javafx.animation.TranslateTransition;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class NavPanelController extends AnchorPane implements Initializable {

    /*-------variables for collapse the navigation panel----------*/
    @FXML
    private AnchorPane sidebar; // injector to sidebar container
    @FXML
    private VBox collapsedNavBar;//injector to sidebar for after collapse
    @FXML
    private Button toggleButton; // injector to toggle button
    private boolean isCollapsed = true;
    private double sidebarWidth;
    private TranslateTransition animationCollapse;//Animation object reference

    //injectors to the sections before navigation panel collapsed
    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;


    /*-------variable set the navigation panel collapse state ------*/
    private final BooleanProperty test=new SimpleBooleanProperty(false);


    /*---------Override the initialize method in Initializable interface--------*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sidebarWidth = sidebar.getPrefWidth()-32;
    }

    /*--------------Getters---------------*/
    public boolean isTest() {
        return test.get();
    }
    public BooleanProperty testProperty() {
        return test;
    }
    public Button getToggleButton() {
        return toggleButton;
    }

    /*--------Load the custom Component using a constructor--------*/
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

    /*--------------Navigation panel animations-------------*/
    //Define translation of the navigation panel
    private void Animation(double animStartPos,double animEndPos){
        animationCollapse = new TranslateTransition(Duration.millis(300), sidebar);
        animationCollapse.setFromX(animStartPos);
        animationCollapse.setToX(animEndPos); // Hide sidebar initially
        animationCollapse.setAutoReverse(true);
        animationCollapse.play();
    }

    //collapse button Event handling function
    @FXML
    public void ToggleButton(ActionEvent event) {
        if(isCollapsed) {
            Animation(0,-sidebarWidth);
            vbox1.setVisible(false);
            vbox2.setVisible(false);
            vbox3.setVisible(false);
            collapsedNavBar.setVisible(true);
            test.set(true);

        }
        else{
            Animation(-sidebarWidth,0);
            collapsedNavBar.setVisible(false);
            vbox1.setVisible(true);
            vbox2.setVisible(true);
            vbox3.setVisible(true);
            test.set(false);
        }
        isCollapsed = !isCollapsed;
    }

}
