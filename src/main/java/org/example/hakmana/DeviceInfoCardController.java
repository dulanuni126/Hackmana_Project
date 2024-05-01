package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.hakmana.model.DatabaseConnection;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class DeviceInfoCardController extends AnchorPane implements Initializable {
     private Stage stage;
     private Scene scene;
     private Parent sceneroot;
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
     @FXML
     private String devId;
     private String user;
     private String brand;
     private String note;
     @Override
     public void initialize(URL url, ResourceBundle resourceBundle) {

     }
     public DeviceInfoCardController() {
          super();
          FXMLLoader fxmlFooterLoader = new FXMLLoader(getClass().getResource("Component/DeviceInfoCard.fxml"));
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

     //handle more info button to load DevDetailedView scene
     public void DetailedViewSceneLoad(ActionEvent event) throws IOException {
          Parent sceneroot = FXMLLoader.load(getClass().getResource("Scene/DevDetailedView.fxml"));
          stage = (Stage)((Node)event.getSource()).getScene().getWindow();
          scene = new Scene(sceneroot);
          stage.setScene(scene);
          stage.show();
     }

     //note adding dialog box control
     public void popupdialog(){
          try{
               FXMLLoader fxmlLoader=new FXMLLoader();
               fxmlLoader.setLocation(getClass().getResource("Scene/dialogbox.fxml"));
               DialogPane dialogPane=fxmlLoader.load();
               dialogPaneController dialogpane=fxmlLoader.getController();
               Dialog<ButtonType> dialog=new Dialog<>();
               dialog.setDialogPane(dialogpane.getDialogpane1());
               dialog.setTitle("ADD NOTE");
               Optional<ButtonType> clickedButton=dialog.showAndWait();
               if(clickedButton.get()==ButtonType.OK){
                    dialogpane.addDetails();
                    DatabaseConnection instance=DatabaseConnection.getInstance();
                    Connection conn=instance.getConnection();
                    Alert.AlertType type=Alert.AlertType.CONFIRMATION;
                    Alert alert=new Alert(type,"");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);
                    alert.getDialogPane().setContentText("do you want to add this note?");
                    alert.getDialogPane().setHeaderText("confirmation!");
                    Optional<ButtonType> reasult=alert.showAndWait();
                    if(reasult.get()==ButtonType.OK){

                         if((dialogpane.getIds()!=null) && (dialogpane.getUserName()!=null) && (dialogpane.getBrand() !=null) && (dialogpane.getNote()!=null)){
                              PreparedStatement notesse=conn.prepareStatement("insert into notes values(?,?,?,?)");
                              notesse.setString(1,dialogpane.getIds());
                              notesse.setString(2,dialogpane.getUserName());
                              notesse.setString(3,dialogpane.getBrand());
                              notesse.setString(4,dialogpane.getNote());
                              notesse.executeUpdate();
                              notesse.close();
                              JOptionPane.showMessageDialog(dialogpane,"add a new note!","alert!",JOptionPane.INFORMATION_MESSAGE);
                         }
                         else{
                              JOptionPane.showMessageDialog(dialogpane,"all field need to fill!","Rejected!",JOptionPane.ERROR_MESSAGE);
                         }


                    }
                    else if(reasult.get()==ButtonType.CANCEL){
                         JOptionPane.showMessageDialog(dialogpane,"cancel the note!","alert!",JOptionPane.INFORMATION_MESSAGE);

                    }


               } else if (clickedButton.get()==ButtonType.CANCEL) {
                    JOptionPane.showMessageDialog(dialogpane,"cancel the note!","alert!",JOptionPane.INFORMATION_MESSAGE);

               }
          } catch (IOException e) {
               throw new RuntimeException(e);
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
     }



}
