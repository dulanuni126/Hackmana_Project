package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.example.hakmana.model.User;

public class UserController {
    @FXML
    private TextField gmailTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField nicTextField;

    @FXML
    private TextField titleTextField;
    private User user;



    // Method to pass data to DesktopFormController
    public void passDataToDesktopFormController() {
        // Get data from user form
        String data = "Data from user form";

        // Call method in DesktopFormController to pass data
       // desktopFormController.receiveDataFromUserForm(data);
    }

    public void assignUserButtonOnAction(ActionEvent event) {
        user=new User();
        user.setNic(nicTextField.getText());
        user.setName(nameTextField.getText());
        user.setTitle(nameTextField.getText());
        user.setGmail(gmailTextField.getText());

        DesktopFormController.user=user;

    }
}
