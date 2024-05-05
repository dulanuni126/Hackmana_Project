package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.hakmana.model.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;

public  class dialogPaneController extends Component implements Initializable  {
    @FXML
    private DialogPane dialogpane1;
    @FXML
    private TextField id;
    @FXML
    private Label date;
    @FXML
    private TextField username;

    @FXML
    private TextArea note;

    @FXML
    private TextField title;

    private String ids;
    private String userName;

    private String Note;

    private Stage stage;

    private String Title;


    public dialogPaneController() {

    }

    public void addDetails() {
        ids = id.getText().isEmpty() ? null : id.getText();
        userName = username.getText().isEmpty() ? null : username.getText();
        Note = note.getText().isEmpty() ? null : note.getText();
        Title=title.getText().isEmpty() ? null : title.getText();
    }

    public String getIds() {
        return ids;
    }

    public String getUserName() {
        return userName;
    }


    public String getNote() {
        return Note;
    }


    public DialogPane getDialogpane1() {
        return dialogpane1;
    }



    public void createnote() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        Connection conn = instance.getConnection();
        addDetails();

        Alert.AlertType type = Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("do you want to add this note?");
        alert.getDialogPane().setHeaderText("confirmation!");
        Optional<ButtonType> reasult = alert.showAndWait();
        String currentdate=date.getText();
        LocalDate localDate=LocalDate.parse(currentdate);
        if (reasult.get() == ButtonType.OK) {

            if ((getIds() != null) && (getUserName() != null) && (getNote() != null)) {
                PreparedStatement notesse = null;
                try {
                    notesse = conn.prepareStatement("insert into notes values(?,?,?,?,?)");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {

                    notesse.setString(1, getIds());
                    notesse.setString(2, getUserName());
                    notesse.setString(3, getNote());
                    notesse.setDate(4,java.sql.Date.valueOf(localDate));
                    notesse.setString(5,Title);
                    notesse.executeUpdate();
                    notesse.close();
                    id.setText(null);
                    username.setText(null);
                    title.setText(null);
                    note.setText(null);

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                JOptionPane.showMessageDialog(this, "the note is successfully added!", "alert!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "All fields need to be filled.", "Rejected!", JOptionPane.ERROR_MESSAGE);
            }

        } else if (reasult.get() == ButtonType.CANCEL) {
            JOptionPane.showMessageDialog(this, "note is cancelled!", "alert!", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String currentDate=localDate.format(formatter);
        date.setText(currentDate);
    }
}

