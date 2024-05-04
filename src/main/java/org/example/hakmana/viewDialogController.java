package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.hakmana.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class viewDialogController {
    @FXML
    private DialogPane dialogpane2;
    @FXML
   private TextArea note1;
    @FXML
   private TextField id1;

    @FXML
    private TextField username1;
    @FXML
    private TextField title1;
    @FXML
    private Label date1;
   private String ids;



    public void setIds(String ids) {
        this.ids = ids;
    }

    public Label getDate1() {
        return date1;
    }

    public DialogPane getDialogPane2() {
        return dialogpane2;
    }

    public TextArea getNote1() {
        return note1;
    }

    public TextField getId1() {
        return id1;
    }

    public TextField getUsername1() {
        return username1;
    }

    public TextField getTitle1() {
        return title1;
    }


    public void edit(){
        title1.setEditable(true);
        note1.setEditable(true);
        username1.setEditable(true);
        id1.setEditable(true);
    }
}
