package org.example.hakmana;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.example.hakmana.model.DatabaseConnection;
import org.example.hakmana.model.SystemUser;


import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateAccountController {
    @FXML
    private AnchorPane parentAnchor;

    @FXML
    private VBox createAccountFields;

    @FXML
    private JFXTextField userNameTxtField;

    @FXML
    private JFXTextField fullNameTxtField;

    @FXML
    private JFXTextField postTxtField;

    @FXML
    private JFXTextField empIdTxtField;

    @FXML
    private JFXPasswordField pwdTextField;

    @FXML
    private JFXTextField emailTxtField;

    @FXML
    private JFXTextField phoneNumTxtField;

    private DatabaseConnection databaseConnection;
    private Connection connection;

    @FXML
    private Button createAccountBtutton;

    static void alertBox(ActionEvent event,String title,String content){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void clearFields() {
        userNameTxtField.setText("");
        fullNameTxtField.setText("");
        postTxtField.setText("");
        empIdTxtField.setText("");
        pwdTextField.setText("");
        emailTxtField.setText("");
        phoneNumTxtField.setText("");

    }
    public void createAccountBtuttonOnAction(ActionEvent actionEvent) {
        if(!(userNameTxtField.getText().equals("")||fullNameTxtField.getText().equals("")||postTxtField.getText().equals("")||pwdTextField.getText().equals("")||phoneNumTxtField.getText().equals(""))){
            databaseConnection=DatabaseConnection.getInstance();
            connection=databaseConnection.getConnection();

            SystemUser user=new SystemUser(userNameTxtField.getText(),fullNameTxtField.getText(),postTxtField.getText(),empIdTxtField.getText(),pwdTextField.getText(),emailTxtField.getText(),phoneNumTxtField.getText());

            // SQL query with placeholders
            String sql = "INSERT INTO systemUser (userName, fullName, post, empId, pwd, email, phoneNum) VALUES (?, ?, ?, ?, SHA2(?,256), ?, ?)";



            try {

                PreparedStatement preparedStatement = connection.prepareStatement(sql);

                preparedStatement.setString(1, userNameTxtField.getText());
                preparedStatement.setString(2, fullNameTxtField.getText());
                preparedStatement.setString(3, postTxtField.getText());
                preparedStatement.setString(4, empIdTxtField.getText());
                preparedStatement.setString(5, pwdTextField.getText());
                preparedStatement.setString(6, emailTxtField.getText());
                preparedStatement.setString(7, phoneNumTxtField.getText());


                // Execute the PreparedStatement
                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    alertBox(actionEvent,"","A new user was inserted successfully!");
                    System.out.println("A new user was inserted successfully!");
                } else {
                    System.out.println("Failed to insert the user.");
                    alertBox(actionEvent,"Error","Failed to insert the user!");
                }
                clearFields();
            } catch (SQLException e) {
                alertBox(actionEvent,"Error","System Error!!");
                e.printStackTrace();
            }

        }else{
          alertBox(actionEvent,"Error","You Should Enter All Required Fields!");
        }

    }
}
