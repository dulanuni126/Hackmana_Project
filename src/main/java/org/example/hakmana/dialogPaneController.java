package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;

public class dialogPaneController extends Component {
    @FXML
    private DialogPane dialogpane1;
    @FXML
    private TextField id;

    @FXML
    private TextField username;
    @FXML
    private TextField brand;
    @FXML
    private TextArea note;

    private String ids;
    private String userName;
    private String Brand;
    private String Note;


    public dialogPaneController() {

    }

    public void addDetails(){
        ids = id.getText().isEmpty() ? null : id.getText();
        userName = username.getText().isEmpty() ? null : username.getText();
        Brand = brand.getText().isEmpty() ? null : brand.getText();
        Note = note.getText().isEmpty() ? null : note.getText();
    }

    public String getIds() {
        return ids;
    }

    public String getUserName() {
        return userName;
    }

    public String getBrand() {
        return Brand;
    }

    public String getNote() {
        return Note;
    }

    public DialogPane getDialogpane1() {
        return dialogpane1;
    }
}

