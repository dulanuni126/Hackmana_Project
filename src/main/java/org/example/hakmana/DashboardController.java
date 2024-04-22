package org.example.hakmana;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.example.hakmana.model.DatabaseConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    @FXML
    private HeaderController headerController;//header custom component injector
    @FXML
    private NavPanelController navPanelController;//NavPanel custom component injector
    @FXML
    private FooterController footerController;
    @FXML
    private PathFinderController pathFinderController;
    @FXML
    private  VBox bodyComponet;//injector for VBox to expand
    @FXML
    private Stage stage;
    @FXML
    private Button addDeviceBtn;
    private  TranslateTransition bodyExpand;//Animation object refernce

    @FXML
    private AnchorPane parentAnchor;
    @FXML
    private HBox hbox1,hbox2,hbox3,hbox4,hbox5;
    @FXML
    private VBox vbox1,vbox2,vbox3,vbox4,vbox5;

    public void initialize(URL location, ResourceBundle resources) {
        //automaticaly upadate the cards
        try{
            //create the connections
            DatabaseConnection instance=DatabaseConnection.getInstance();
            Connection conn=instance.getConnection();

            int count1;
            int count2;
            //get numbers of columns from database
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT t.TABLE_NAME\n" +
                    "FROM information_schema.TABLES t\n" +
                    "INNER JOIN information_schema.COLUMNS c ON t.TABLE_NAME = c.TABLE_NAME\n" +
                    "WHERE c.COLUMN_NAME = 'regNum' \n" +
                    "  AND t.TABLE_SCHEMA = 'hakmanaedm'");
            int size=0;
            while(rs.next()){
                size++;
            }
            System.out.println(size);
            String[] table=new String[size];
            int item=0;
            rs.close();
            ResultSet rs0=st.executeQuery("SELECT t.TABLE_NAME\n" +
                    "FROM information_schema.TABLES t\n" +
                    "INNER JOIN information_schema.COLUMNS c ON t.TABLE_NAME = c.TABLE_NAME\n" +
                    "WHERE c.COLUMN_NAME = 'regNum' \n" +
                    "  AND t.TABLE_SCHEMA = 'hakmanaedm';");
            while(rs0.next()) {

                table[item] = rs0.getString(1);
                System.out.println(table[item]);
                item++;

            }
            rs0.close();
            //update the cards
            for(int j=0;j<size;j++) {
                count1=0;
                count2=0;
                if(!(table[j].equals("user"))) {
                    PreparedStatement pr = conn.prepareStatement("SELECT regNum FROM " +table[j]+ " WHERE status=?");
                    pr.setString(1, "Active");
                    ResultSet rs1 = pr.executeQuery();
                    while (rs1.next()) {
                        count1++;
                    }
                    Label label1 = new Label(table[j] +" "+ Integer.toString(count1));
                    vbox5.getChildren().add(label1);
                    rs1.close();
                    pr.setString(1, "inactive");
                    ResultSet rs2 = pr.executeQuery();
                    while (rs2.next()) {
                        count2++;
                    }
                    Label label2 = new Label(table[j] + " "+Integer.toString(count2));
                    vbox2.getChildren().add(label2);
                    rs2.close();
                    Label label3=new Label(table[j] + " "+Integer.toString(count1+count2));
                    vbox4.getChildren().add(label3);

                }
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            headerController.setFontSize("3em");
            headerController.setTitleMsg("Welcome");
            headerController.setUsernameMsg("Mr.Udara Mahanama");
            headerController.setDesignationMsg("Development Officer");
            navPanelController.setDashboardBorder();
            pathFinderController.setSearchBarVisible(false);

            //create the event listener to the navigation panel ToggleButton() method
            navPanelController.collapseStateProperty().addListener((observable, oldValue, newValue) ->{
                if(newValue){
                    expand();
                }else{
                    collapse();
                }
            });



        }



    }

    private void Animation(double animStartPos,double animEndPos){
        bodyExpand = new TranslateTransition(Duration.millis(300), bodyComponet);
        bodyExpand.setFromX(animStartPos);
        bodyExpand.setToX(animEndPos); // expand VBox
        bodyExpand.setAutoReverse(true);
        bodyExpand.play();

    }
    public  void expand() {
        ///String cssRule = "-fx-min-width: 992px;";
        Double W1=bodyComponet.getWidth()+244;
        Animation(0, -244);
        bodyComponet.setMinWidth(W1);
        //bodyComponet.getStyleClass().add(cssRule);

    }
    public  void collapse() {
        Double W1=bodyComponet.getWidth()-244;
        Animation(-244, 0);
        bodyComponet.setMinWidth(W1);
    }
    public void addDeviceBtnDialogOpen(ActionEvent event) throws IOException {
        FXMLLoader addDevicefxmlLoad = new FXMLLoader();
        addDevicefxmlLoad.setLocation(getClass().getResource("Scene/DesktopForm.fxml"));
        DialogPane addDeviceDialogPane=addDevicefxmlLoad.load();

        Dialog<ButtonType> dialog=new Dialog<>();
        dialog.setDialogPane(addDeviceDialogPane);
        dialog.setTitle("Contact Us");

        Optional<ButtonType> clickedButton=dialog.showAndWait();

    }
}