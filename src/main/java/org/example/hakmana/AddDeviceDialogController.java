package org.example.hakmana;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.hakmana.model.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AddDeviceDialogController implements Initializable {
    @FXML
    public ChoiceBox<String> devCat;
    private String devCategoryName;
    private String devRegNum;

    //Device details
    //common
    @FXML
    public TextField modelTextField;
    @FXML
    public TextField regNumTextField;
    @FXML
    public ChoiceBox<String> StatusChoiseBox;


    //other details
    private ArrayList<HBox> otherHboxList;
    private ArrayList<Label> otherLblList;
    private ArrayList<TextField> otherTextList;
    @FXML
    public VBox otherDetailVbox;
    @FXML
    public Label other1Lbl;
    @FXML
    public HBox other1Hbox;
    @FXML
    public TextField other1;
    @FXML
    public HBox other2Hbox;
    @FXML
    public Label other2Lbl;
    @FXML
    public TextField other2;
    @FXML
    public HBox other3Hbox;
    @FXML
    public Label other3Lbl;
    @FXML
    public TextField other3;
    @FXML
    public HBox other4Hbox;
    @FXML
    public Label other4Lbl;
    @FXML
    public TextField other4;
    @FXML
    public HBox other5Hbox;
    @FXML
    public Label other5Lbl;
    @FXML
    public TextField other5;
    @FXML
    public HBox other6Hbox;
    @FXML
    public ChoiceBox<String> OSChoiseBox;
    @FXML
    public HBox other7Hbox;
    @FXML
    public Label other7Lbl;
    @FXML
    public TextField other7;
    @FXML
    public HBox other8Hbox;
    @FXML
    public ChoiceBox<String> FloppyDiskChoiseBox;
    @FXML
    public HBox other9Hbox;
    @FXML
    public ChoiceBox<String> SoundCardChoiseBox;
    @FXML
    public HBox other10Hbox;
    @FXML
    public ChoiceBox<String> TVCardChoiseBox;
    @FXML
    public HBox other11Hbox;
    @FXML
    public ChoiceBox<String> NetworkCardChoiseBox;


    //input Dev details
    private ArrayList<HBox> inputHboxList;
    private ArrayList<Label> inputLblList;
    private ArrayList<TextField> inputTextList;
    @FXML
    public VBox inputVbox;
    @FXML
    public HBox input1Hbox;
    @FXML
    public Label input1Lbl;
    @FXML
    public TextField input1;
    @FXML
    public HBox input2Hbox;
    @FXML
    public Label input2Lbl;
    @FXML
    public TextField input2;
    @FXML
    public HBox input3Hbox;
    @FXML
    public Label input3Lbl;
    @FXML
    public TextField input3;
    @FXML
    public HBox input4Hbox;
    @FXML
    public Label input4Lbl;
    @FXML
    public TextField input4;

    //output Dev details
    private ArrayList<HBox> outputHboxList;
    private ArrayList<Label> outputLblList;
    private ArrayList<TextField> outputTextList;
    @FXML
    public VBox outputVbox;
    @FXML
    public HBox output1Hbox;
    @FXML
    public Label output1Lbl;
    @FXML
    public TextField output1;
    @FXML
    public HBox output2Hbox;
    @FXML
    public Label output2Lbl;
    @FXML
    public TextField output2;
    @FXML
    public HBox output3Hbox;
    @FXML
    public Label output3Lbl;
    @FXML
    public TextField output3;

    //user details
    private ArrayList<TextField> userTextLsit;
    @FXML
    public VBox userDetailsVbox;
    @FXML
    public TextField userNIC;
    @FXML
    public TextField userTitle;
    @FXML
    public TextField userName;
    @FXML
    public TextField userGmail;

    @FXML
    public HBox interactionHbox;
    @FXML
    public Button submitButton;
    @FXML
    public Button resetBtn;
    @FXML
    public Button addUserButton;

    //Array fo populate the choiceBoxes
    private final String[] devCategories={"Desktop","Photocopy Machines","Monitors","Projectors","Laptops","Printers","UPS"};
    private final String[] deviceStatus={"Active","Repairing","Inactive"};
    private final String[] YN={"Yes","No"};
    private final String[] WinLin={"Windows","Linux"};
    private final String[] OnboardDecicated={"On Board","Dedicated"};

    private boolean isFromComponent;

    public static User user;

    //for get new values from the textFields
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

    public void setDevCat() {
        devCat.setValue("Select a device");
    }

    /*-------------------------------Initialize---------------------------------*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        user=new User();
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

        resetBtnAction();

        //update the register number field realtime
        regNumTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            //Check the given regNUm is available

            // Enable the submitButton only if regNumTextField is not empty
            submitButton.setDisable(newValue.isEmpty());

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
            addUserButton.setDisable(newValue.isEmpty());

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
            listnerReset();
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
                setOtherDetails(new String[]{"Ram","CPU","Storage","Display","Graphic Card"});
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

            default -> {
                System.out.println(getDevCategoryName());
            }

        }

    }
    private void setOtherDetails(String[] otherlblText){
        otherDetailVbox.setVisible(true);
        for(int i=0;i< otherlblText.length;i++){
            otherHboxList.get(i).setVisible(true);
            otherTextList.get(i).setVisible(true);
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
    @FXML
    public void submitButtonOnAction(ActionEvent event) {
        newValues.clear();
        boolean isSuccessed;
        switch (getDevCategoryName()) {
            case "Desktop" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                getTextFieldText(outputTextList);
                getTextFieldText(inputTextList);
                getChoiceBoxValue();
                newValues.add(userNIC.getText());

                // Call addUser in a background thread
                new Thread(this::addUser).start();

                isSuccessed=new Desktop().insertDevice(newValues);


            }
            case "Photocopy Machines" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);

                isSuccessed=new PhotocpyMchine().insertDevice(newValues);
            }
            case "Monitors" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);

                isSuccessed=new Monitors().insertDevice(newValues);

            }
            case "Projectors" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());

                isSuccessed=new Projectors().insertDevice(newValues);

            }
            case "Laptops" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);
                newValues.add( OSChoiseBox.getValue());
                newValues.add(userNIC.getText());

                // Call addUser in a background thread
                new Thread(this::addUser).start();

                isSuccessed =new Laptops().insertDevice(newValues);

            }
            case "Printers" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);

                isSuccessed=new Printer().insertDevice(newValues);

            }
            case "UPS" -> {
                newValues.add(getDevRegNum());
                newValues.add(modelTextField.getText());
                newValues.add(StatusChoiseBox.getValue());
                getTextFieldText(otherTextList);

                System.out.println(newValues);

                isSuccessed=new UPS().insertDevice(newValues);

            }
            default -> {
                alert(Alert.AlertType.WARNING,"No Category","Please select a category first");
                isSuccessed=false;
            }
        }

        if(isSuccessed) {
            alert(Alert.AlertType.INFORMATION,"Success","Successfully inserted new device \n"+newValues);
            listnerReset();
            setDevCat();
            if(!isFromComponent){
                setDevCat();
            }
        }
        else {
            clearAll();
            setDevCat();
        }

    }

    // Reset the form into general form according to the event listener
    private void listnerReset(){
        clearAll();//clearAll the fields

        setChoiceBoxDisablity(true);//disable all the choice boxes

        //set text field to non-editable and colors
        setEditable(new ArrayList<>(List.of(modelTextField)), false, "grey");
        setEditable(otherTextList, false, "grey");
        setEditable(inputTextList, false, "grey");
        setEditable(outputTextList, false, "grey");
        setEditable(userTextLsit, false, "grey");

        //disable the addUserButton
        addUserButton.setDisable(true);

        if(!isFromComponent) {
            //except the common vbox set all other fields to not visible
            otherDetailVbox.setVisible(false);
            for (HBox h : otherHboxList) {
                h.setVisible(false);
            }
            for(TextField t:otherTextList){
                t.setVisible(false);
            }

            inputVbox.setVisible(false);
            outputVbox.setVisible(false);
            userDetailsVbox.setVisible(false);

        }
    }

    //handle reset button action
    @FXML
    public void resetBtnAction(){
        listnerReset();
        if(!isFromComponent){
            setDevCat();
        }
    }

    //clear all  the text field and choice box values
    private void clearAll(){
        clearChoiceBox();
        regNumTextField.clear();
        modelTextField.clear();
        for(TextField fields:otherTextList){
            fields.clear();
        }
        for(TextField fields:inputTextList){
            fields.clear();
        }
        for(TextField fields:outputTextList){
            fields.clear();
        }
        for(TextField fields:userTextLsit){
            fields.clear();
        }

    }

    private void alert(Alert.AlertType alertType,String title,String content){
        Alert alert=new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();

    }



    /*---------------------Create Configurations--------------------*/

    //According to the device selected in DeviceMngmntSmmryScene load the view
    //disable the devCat dropdown box
    public void setCardForm(String cat){
        devCat.setValue(cat);
        devCat.setDisable(true);
        setDevCategoryName(cat);
        isFromComponent=true;
        setView();
    }

    //set the All Choice box Disability
    private void setChoiceBoxDisablity(boolean isDisable){
        FloppyDiskChoiseBox.setDisable(isDisable);
        OSChoiseBox.setDisable(isDisable);
        StatusChoiseBox.setDisable(isDisable);
        SoundCardChoiseBox.setDisable(isDisable);
        TVCardChoiseBox.setDisable(isDisable);
        OSChoiseBox.setDisable(isDisable);
        NetworkCardChoiseBox.setDisable(isDisable);
    }

    //set the Choice box Visibility(except Status Choice Box)
    private void setChoiceBoxVisibilty(boolean isVisible){
        other6Hbox.setVisible(isVisible);
        other8Hbox.setVisible(isVisible);
        other9Hbox.setVisible(isVisible);
        other10Hbox.setVisible(isVisible);
        other11Hbox.setVisible(isVisible);
    }

    //clear all the Choice boxes values
    private void clearChoiceBox(){
        FloppyDiskChoiseBox.getSelectionModel().clearSelection();
        OSChoiseBox.getSelectionModel().clearSelection();
        StatusChoiseBox.getSelectionModel().clearSelection();
        SoundCardChoiseBox.getSelectionModel().clearSelection();
        TVCardChoiseBox.getSelectionModel().clearSelection();
        NetworkCardChoiseBox.getSelectionModel().clearSelection();
    }

    //get the Choice Box values and add to the newValues arraylist(except Status Choice Box)
    private void getChoiceBoxValue(){
        newValues.add(OSChoiseBox.getValue());
        newValues.add(FloppyDiskChoiseBox.getValue());
        newValues.add(SoundCardChoiseBox.getValue());
        newValues.add(TVCardChoiseBox.getValue());
        newValues.add(NetworkCardChoiseBox.getValue());
    }

    //set the text fields editing ability and border color
    private void setEditable(ArrayList<TextField> textFieldslist, boolean setEdit, String color){
        for(TextField textField:textFieldslist){
            textField.setEditable(setEdit);
            textField.setStyle("-fx-border-color: "+color+";-fx-border-width: 2;-fx-border-radius: 5");
        }
    }

    //get the text fields values
    private void getTextFieldText(ArrayList<TextField> textFieldslists){
        for(TextField textField:textFieldslists){
            if(textField.getText().isEmpty() && textField.isVisible()){
                alert(Alert.AlertType.CONFIRMATION,"Confirm","Empty Field detected\nDo you want to continue");
                clearAll();
                listnerReset();
                break;
            }
            else if(textField.isVisible()){
                newValues.add(textField.getText());
            }

        }
    }

    /*------------------------Interactions with User TABLE-----------------------------------*/
    @FXML
    private void addUser(){
            if(user.isNicAvailable(userNIC.getText())==null) {
                //add new user to the user table
                user.insertUser(new ArrayList<>(List.of(userNIC.getText(), userName.getText(), userTitle.getText(), userGmail.getText())));
            }
    }

    
}
