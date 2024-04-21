package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.security.PublicKey;
import java.util.ResourceBundle;

public class HeaderController extends VBox implements Initializable {

    /*Injectors for Labels in fxml file*/
    @FXML
    private Text headerTitle;
    @FXML
    private Text userName;
    @FXML
    private Text designation;

    /*Variables for change the labels*/
    private String titleMsg;
    private String fontSize;
    private String usernameMsg;
    private String designationMsg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public HeaderController() {
        super();
        FXMLLoader fxmlHeaderLoader = new FXMLLoader(getClass().getResource("Component/Header.fxml"));
        fxmlHeaderLoader.setController(this);
        fxmlHeaderLoader.setRoot(this);

        try{
            fxmlHeaderLoader.load();
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getTitleMsg() {
        return titleMsg;
    }

    public void setTitleMsg(String titleMsg) {
        String fontStyle = "-fx-font-size:"+fontSize+";";
        headerTitle.setStyle(fontStyle);
        this.titleMsg = titleMsg;
        headerTitle.setText(this.titleMsg);
    }

    public String getUsernameMsg() {
        return usernameMsg;
    }

    public void setUsernameMsg(String usernameMsg) {
        this.usernameMsg = usernameMsg;
        userName.setText(this.usernameMsg);
    }

    public String getDesignationMsg() {
        return designationMsg;
    }

    public void setDesignationMsg(String designationMsg) {
        this.designationMsg = designationMsg;
        designation.setText(this.designationMsg);
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }
}
