package org.example.hakmana.componentControllers;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;


public class FooterController extends VBox implements Initializable {
    @FXML
    private Button ContactusBtn;
    @FXML
    private Label dateLabel;
    @FXML
    private Label timeLabel;
    private boolean test=true;
    private static Task<Void> updateTimeTask;
    private Thread clockThread;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Task for updating date and time
        updateTimeTask = new Task<>() {
            @Override
            protected Void call() throws Exception {
                while (test) {
                    SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

                    String currentDate = dateFormatter.format(new Date());
                    String currentTime = timeFormatter.format(new Date());

                    Platform.runLater(() -> {
                        dateLabel.setText(currentDate);
                        timeLabel.setText(currentTime);
                    });
                    Thread.sleep(1000); // Update every second
                }
                return null;
            }
        };
        clockThread=new Thread(updateTimeTask);
        clockThread.setDaemon(true);
        clockThread.start();
    }

    public FooterController() {
        super();
        String filePath = "src/main/resources/org/example/hakmana/Component/Footer.fxml";
        FXMLLoader fxmlFooterLoader = null;
        try {
            fxmlFooterLoader = new FXMLLoader(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        fxmlFooterLoader.setController(this);
        fxmlFooterLoader.setRoot(this);

        try {
            fxmlFooterLoader.load();
        }
        catch (IOException Footerexception){
            throw new RuntimeException(Footerexception);
        }
    }
    public void ContactusBtnDialogOpen(ActionEvent event) throws IOException{
        String filePath = "src/main/resources/org/example/hakmana/Component/ContactUsDialogPane.fxml";
        FXMLLoader contactUsfxmlLoad = null;
        try {
            contactUsfxmlLoad = new FXMLLoader(new File(filePath).toURI().toURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        DialogPane conactUsDialogPane=contactUsfxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(conactUsDialogPane);
        dialog.setTitle("Contact Us");

        Optional<ButtonType> clickedButton=dialog.showAndWait();

    }
}
