package org.example.hakmana.componentControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeviceInfoCardController extends AnchorPane implements Initializable {
     private Stage stage;
     private Scene scene;
     private Parent sceneroot;
     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {

     }
     public DeviceInfoCardController() {
          super();
          String filePath = "src/main/resources/org/example/hakmana/Component/DeviceInfoCard.fxml";
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
          catch (IOException e){
               throw new RuntimeException(e);
          }
     }
     @FXML
     private Button DetailedViewBtn;
     @FXML
     private TextField devIdTxt;
     @FXML
     private TextField brandTxt;
     @FXML
     private TextField userTxt;
     @FXML
     private TextArea noteTxtArea;
     @FXML
     private AnchorPane root;
     @FXML
     private Pane addBtn;
     @FXML
     private Pane moreInfoBtn;

     private String devId;
     private String user;
     private String brand;
     private String note;

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

     public String getDevId() {
          return devId;
     }

     public void setDevId(String devId) {
          this.devId = devId;
          devIdTxt.setText(this.devId);
     }

     public String getUser() {
          return user;
     }

     public void setUser(String user) {
          this.user = user;
          userTxt.setText(this.user);
     }

     public String getBrand() {
          return brand;
     }

     public void setBrand(String brand) {
          this.brand = brand;
          brandTxt.setText(this.brand);
     }

     public String getNote() {
          return note;
     }

     public void setNote(String note) {
          this.note = note;
          noteTxtArea.setText(this.note);
     }

     public void DetailedViewSceneLoad(ActionEvent event) throws IOException {
          String filePath = "src/main/resources/org/example/hakmana/Scene/DevDetailedView.fxml";
          try {
               Parent sceneRoot = FXMLLoader.load(new File(filePath).toURI().toURL());
               stage = (Stage)((Node)event.getSource()).getScene().getWindow();
               scene = new Scene(sceneRoot);
               stage.setScene(scene);
               stage.show();
          } catch (MalformedURLException e) {
               throw new RuntimeException(e);
          }
     }


}
