package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.hakmana.model.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddDeviceDialogController implements Initializable {
    @FXML
    private ChoiceBox<String> devCat;
    private String devCategoryName;
    private String devRegNum;

    //Device details
    //common
    @FXML
    private VBox commonVbox;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField regNumTextField;
    @FXML
    private ChoiceBox<String> StatusChoiseBox;


    //other details
    private ArrayList<HBox> otherHboxList;
    private ArrayList<Label> otherLblList;
    private ArrayList<TextField> otherTextList;
    @FXML
    private VBox otherDetailVbox;
    @FXML
    private Label other1Lbl;
    @FXML
    private HBox other1Hbox;
    @FXML
    private TextField other1;
    @FXML
    private HBox other2Hbox;
    @FXML
    private Label other2Lbl;
    @FXML
    private TextField other2;
    @FXML
    private HBox other3Hbox;
    @FXML
    private Label other3Lbl;
    @FXML
    private TextField other3;
    @FXML
    private HBox other4Hbox;
    @FXML
    private Label other4Lbl;
    @FXML
    private TextField other4;
    @FXML
    private HBox other5Hbox;
    @FXML
    private Label other5Lbl;
    @FXML
    private TextField other5;
    @FXML
    private HBox other6Hbox;
    @FXML
    private ChoiceBox<String> OSChoiseBox;
    @FXML
    private HBox other7Hbox;
    @FXML
    private Label other7Lbl;
    @FXML
    private TextField other7;
    @FXML
    private HBox other8Hbox;
    @FXML
    private ChoiceBox<String> FloppyDiskChoiseBox;
    @FXML
    private HBox other9Hbox;
    @FXML
    private ChoiceBox<String> SoundCardChoiseBox;
    @FXML
    private HBox other10Hbox;
    @FXML
    private ChoiceBox<String> TVCardChoiseBox;
    @FXML
    private HBox other11Hbox;
    @FXML
    private ChoiceBox<String> NetworkCardChoiseBox;


    //input Dev details
    private ArrayList<HBox> inputHboxList;
    private ArrayList<Label> inputLblList;
    private ArrayList<TextField> inputTextList;
    @FXML
    private VBox inputVbox;
    @FXML
    private HBox input1Hbox;
    @FXML
    private Label input1Lbl;
    @FXML
    private TextField input1;
    @FXML
    private HBox input2Hbox;
    @FXML
    private Label input2Lbl;
    @FXML
    private TextField input2;
    @FXML
    private HBox input3Hbox;
    @FXML
    private Label input3Lbl;
    @FXML
    private TextField input3;
    @FXML
    private HBox input4Hbox;
    @FXML
    private Label input4Lbl;
    @FXML
    private TextField input4;

    //output Dev details
    private ArrayList<HBox> outputHboxList;
    private ArrayList<Label> outputLblList;
    private ArrayList<TextField> outputTextList;
    @FXML
    private VBox outputVbox;
    @FXML
    private HBox output1Hbox;
    @FXML
    private Label output1Lbl;
    @FXML
    private TextField output1;
    @FXML
    private HBox output2Hbox;
    @FXML
    private Label output2Lbl;
    @FXML
    private TextField output2;
    @FXML
    private HBox output3Hbox;
    @FXML
    private Label output3Lbl;
    @FXML
    private TextField output3;

    //user details
    private ArrayList<TextField> userTextLsit;
    @FXML
    private VBox userDetailsVbox;
    @FXML
    private Button assignUserBtn;
    @FXML
    private TextField userNIC;
    @FXML
    private TextField userTitle;
    @FXML
    private TextField userName;
    @FXML
    private TextField userGmail;

    @FXML
    private HBox interactionHbox;
    @FXML
    private Button submitButton;
    @FXML
    private Button resetBtn;
    @FXML
    private Button addUserButton;

    //Array fo populate the choiceBoxes
    private String[] devCategories={"Desktop","Photocopy Machines","Monitors","Projectors","Laptops","Printers","UPS"};
    private String[] deviceStatus={"Active","Repairing","Inactive"};
    private String[] YN={"Yes","No"};
    private String[] WinLin={"Windows","Linux"};
    private String[] OnboardDecicated={"On Board","Dedicated"};

    private boolean isFromComponent;

    public static User user;

    //for get new vlaues from the textFields
    ArrayList<String> newValues=new ArrayList<>();

    /*----------------------Getters and Setters----------------------*/
    public String getDevCategoryName() {
        return devCategoryName;
    }
    public void setDevCategoryName(String devCategoryName) {
        this.devCategoryName = devCategoryName;
    }
    public String getDevRegNum() {
        return devRegNum;
    }
    public void setDevRegNum(String devRegNum) {
        this.devRegNum = devRegNum;
    }

    /*-------------------------------Initialize---------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user=new User();
        devCat.setValue("Select device");

        //populate the choiceboxes
        devCat.getItems().addAll(devCategories);
        StatusChoiseBox.getItems().addAll(deviceStatus);
        FloppyDiskChoiseBox.getItems().addAll(YN);
        NetworkCardChoiseBox.getItems().addAll(OnboardDecicated);
        SoundCardChoiseBox.getItems().addAll(OnboardDecicated);
        TVCardChoiseBox.getItems().addAll(OnboardDecicated);
        OSChoiseBox.getItems().addAll(WinLin);

        //get all the other details vbox label and Hboxes
        otherHboxList=new ArrayList<>(List.of(other1Hbox,other2Hbox,other3Hbox,other4Hbox,other5Hbox,other7Hbox));
        otherLblList=new ArrayList<>(List.of(other1Lbl,other2Lbl,other3Lbl,other4Lbl, other5Lbl,other7Lbl));
        otherTextList=new ArrayList<>(List.of(other1,other2,other3,other4,other5,other7));

        //get all the input vbox label and Hboxes and textfield
        inputHboxList=new ArrayList<>(List.of(input1Hbox,input2Hbox,input3Hbox,input4Hbox));
        inputLblList=new ArrayList<>(List.of(input1Lbl,input2Lbl,input3Lbl,input4Lbl));
        inputTextList=new ArrayList<>(List.of(input1,input2,input3,input4));

        //get all the output vbox label and Hboxes and textfield
        outputHboxList=new ArrayList<>(List.of(output1Hbox,output2Hbox,output3Hbox));
        outputLblList=new ArrayList<>(List.of(output1Lbl,output2Lbl,output3Lbl));
        outputTextList=new ArrayList<>(List.of(output1,output2,output3));

        //get all the user textfield
        userTextLsit=new ArrayList<>(List.of(userNIC,userName,userTitle,userGmail));

        reset();

        //update the register number field realtime
        regNumTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            // Enable the submitButton only if regNumTextField is not empty
            submitButton.setDisable(newValue.isEmpty());
            addUserButton.setDisable(newValue.isEmpty() );

            //set editable textfield when user enter register number
            setEditable(new ArrayList<>(List.of(modelTextField)),true,"#03AED2");
            setEditable(otherTextList,true,"#03AED2");
            setEditable(inputTextList,true,"#03AED2");
            setEditable(outputTextList,true,"#03AED2");
            setEditable(userTextLsit,true,"#03AED2");
            //set choice box enable
            setChoiceBoxDisablity(false);
            setDevRegNum(newValue);

        });

        //Realtime get the Users
        userNIC.textProperty().addListener((observable, oldValue, newValue) -> {
            // Enable the submitButton only if regNumTextField is not empty
            assignUserBtn.setDisable(newValue.isEmpty());

            // Check if the newValue is available in the users array
            User user = new User().isNicAvailable(newValue);
            if (user != null) {
                // Auto-fill the other text fields
                userGmail.setText(user.getGmail());
                userName.setText(user.getName());
                userTitle.setText(user.getTitle());
            }
        });

        //update the device category selecting choicebox realtime
        devCat.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            reset();
            setDevCategoryName(newValue);
            setView();
        });

        // Disable the submitButton initially if regNumTextField is empty
        submitButton.setDisable(regNumTextField.getText().isEmpty());
        addUserButton.setDisable(regNumTextField.getText().isEmpty());

    }
    private void setView(){
        switch (getDevCategoryName()) {
            case "Desktop" -> {
                setOtherDetails(new String[]{"Serial Number","Purchased Form","Ram","Processor","Warranty","Hard Disk"});
                setOutputDetails(new String[]{"Monitor Register Number","Projector Register Number","Speaker Register Number"});
                setInputDetails(new String[]{"Mouse Register Number","Keyboard Register Number","Mic Register Number","Scanner Register Number"});
                userDetailsVbox.setVisible(true);
                setChoiceBoxVisibilty(true);
            }
            case "Photocopy Machines" ->{
                setOtherDetails(new String[]{"Copying Capability"});
                setChoiceBoxVisibilty(false);
            }
            case "Monitors" ->{
                setOtherDetails(new String[]{"Desktop Register Number"});
                setChoiceBoxVisibilty(false);
            }
            case "Projectors"->{

            }
            case "Laptops" -> {
                setOtherDetails(new String[]{"Ram","CPU","Storage","Display","Operating System","Graphic Card"});
                setChoiceBoxVisibilty(false);
                other6Hbox.setVisible(true);
                userDetailsVbox.setVisible(true);
            }
            case "Printers" -> {
                setOtherDetails(new String[]{"Serial Number","Paper Input","Paper Output","Warranty"});
                setChoiceBoxVisibilty(false);
            }
            case "UPS" -> {
                setOtherDetails(new String[]{"Backup Power","Runtime","Desktop Register Number"});
                setChoiceBoxVisibilty(false);
            }

            default -> throw new IllegalStateException("Unexpected value: ");

        }

    }
    private void setOtherDetails(String[] otherlblText){
        otherDetailVbox.setVisible(true);
        for(int i=0;i< otherlblText.length;i++){
            otherHboxList.get(i).setVisible(true);
            otherLblList.get(i).setText(otherlblText[i]);
        }
    }
    private void setInputDetails(String[] inputLblText){
        inputVbox.setVisible(true);
        for(int i=0;i< inputLblText.length;i++){
            inputHboxList.get(i).setVisible(true);
            inputLblList.get(i).setText(inputLblText[i]);
        }
    }
    private void setOutputDetails(String[] outputLblText){
        outputVbox.setVisible(true);
        for(int i=0;i< outputLblText.length;i++){
            outputHboxList.get(i).setVisible(true);
            outputLblList.get(i).setText(outputLblText[i]);
        }

    }


    /*--------------------------Interaction------------------------------------*/
    public void submitButtonOnAction(ActionEvent event) {
        switch (getDevCategoryName()) {
            case "Desktop" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                getTextFieldText(outputTextList);
                getTextFieldText(inputTextList);
                getChoiseBoxValue();
                newValues.add(userNIC.getText());

                addUser();
                new Desktop().insertDevice(newValues);
                    //showDeviceDetail();

            }
            case "Photocopy Machines" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add(getDevRegNum());

                new PhotocpyMchine().insertDevice(newValues);
            }
            case "Monitors" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add(getDevRegNum());


                new Monitors().insertDevice(newValues);

            }
            case "Projectors" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add(getDevRegNum());

                //System.out.println(newValues);
                new Projectors().insertDevice(newValues);

            }
            case "Laptops" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add( OSChoiseBox.getValue());
                newValues.add(getDevRegNum());

                addUser();
                new Laptops().insertDevice(newValues);


            }
            case "Printers" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add(getDevRegNum());


                new Printer().insertDevice(newValues);

            }
            case "UPS" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add(getDevRegNum());

                new UPS().insertDevice(newValues);

            }

            default -> throw new IllegalStateException("Unexpected value: " );
        }

    }
    // Reset the form
    private void reset(){
        clearChoiceBox();
        setChoiceBoxDisablity(true);

        //set non-editable textfield until user enter register number
        setEditable(new ArrayList<>(List.of(modelTextField)),false,"grey");
        setEditable(otherTextList,false,"grey");
        setEditable(inputTextList,false,"grey");
        setEditable(outputTextList,false,"grey");
        setEditable(userTextLsit,false,"grey");

        otherDetailVbox.setVisible(false);
        inputVbox.setVisible(false);
        outputVbox.setVisible(false);
        userDetailsVbox.setVisible(false);
        for(HBox h:otherHboxList){
            h.setVisible(false);
        }

        UserAssignDialogController.isAssignUserButtonClicked=false;
        addUserButton.setDisable(false);
    }

    private void clear(){
        System.out.println("clear");
    }
    //cancel button
    @FXML
    private void cancel(){
        if(isFromComponent){
            reset();
            devCat.setValue("Select device");
        }
        else{
            clear();
        }
    }

    private void alert(Alert.AlertType alertType,String title,String content){
        Alert alert=new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }

    /*---------------------Create Configurations--------------------*/
    public void setCardForm(String cat){
        devCat.setValue(cat);
        devCat.setDisable(true);
        setDevCategoryName(cat);
        setView();
    }

    //set disable the choice boxes
    private void setChoiceBoxDisablity(boolean isDisable){
        FloppyDiskChoiseBox.setDisable(isDisable);
        OSChoiseBox.setDisable(isDisable);
        StatusChoiseBox.setDisable(isDisable);
        SoundCardChoiseBox.setDisable(isDisable);
        TVCardChoiseBox.setDisable(isDisable);
        OSChoiseBox.setDisable(isDisable);
        NetworkCardChoiseBox.setDisable(isDisable);
    }
    private void setChoiceBoxVisibilty(boolean isVisible){
        other6Hbox.setVisible(isVisible);
        other8Hbox.setVisible(isVisible);
        other9Hbox.setVisible(isVisible);
        other10Hbox.setVisible(isVisible);
        other11Hbox.setVisible(isVisible);
    }
    private void clearChoiceBox(){
        //clear all the slected choise box values
        OSChoiseBox.getSelectionModel().clearSelection();
        StatusChoiseBox.getSelectionModel().clearSelection();
        SoundCardChoiseBox.getSelectionModel().clearSelection();
        TVCardChoiseBox.getSelectionModel().clearSelection();
        NetworkCardChoiseBox.getSelectionModel().clearSelection();
    }
    private void getChoiseBoxValue(){
        newValues.add(OSChoiseBox.getValue());
        newValues.add(FloppyDiskChoiseBox.getValue());
        newValues.add(SoundCardChoiseBox.getValue());
        newValues.add(TVCardChoiseBox.getValue());
        newValues.add(NetworkCardChoiseBox.getValue());
    }
    private void setEditable(ArrayList<TextField> textFieldslist, boolean setEdit, String color){
        for(TextField textField:textFieldslist){
            textField.setEditable(setEdit);
            textField.setStyle("-fx-border-color: "+color+";-fx-border-width: 2;-fx-border-radius: 5");
        }
    }
    private void getTextFieldText(ArrayList<TextField> textFieldslists){
        for(TextField textField:textFieldslists){
            if(textField.getText().isEmpty()){
                alert(Alert.AlertType.ERROR,"Error","Empty Filed detected");
            }
            newValues.add(textField.getText());
        }
    }

    /*------------------------Interactions with User TABLE-----------------------------------*/
    @FXML
    private void addUser(){
            if(user.isNicAvailable(userNIC.getText())==null) {
                //add new user to the user table
                new User().insertUser(new ArrayList<>(List.of(userNIC.getText(), userName.getText(), userTitle.getText(), userGmail.getText())));
            }
    }
    private void userDetails(){
        userDetailsVbox.setVisible(true);
    }
    
}
