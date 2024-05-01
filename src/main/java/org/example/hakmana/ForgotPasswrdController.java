package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.hakmana.model.SystemUser;
import org.example.hakmana.model.User;

import javax.mail.MessagingException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class ForgotPasswrdController {
    public SystemUser systemUser =new SystemUser();
    private String usrEmail;

    //injectors for fxml components
    @FXML
    private VBox usrMailVbox,verificationCodeVbox,newPsswrdVbox;
    @FXML
    private Label outputLbl;
    @FXML
    private TextField usrEmailField,verificationCodeField,newPsswrdFiled1,newPsswrdFiled2;
    @FXML
    private Button nextBtn,verfiyBtn;


    public VBox getUsrMailVbox() {
        return usrMailVbox;
    }

    public VBox getVerificationCodeVbox() {
        return verificationCodeVbox;
    }

    public VBox getnewPsswrdVbox() {
        return newPsswrdVbox;
    }

    public Label getOutputLbl() {
        return outputLbl;
    }

    public TextField getUsrEmailField() {
        return usrEmailField;
    }

    public TextField getVerificationCodeField() {
        return verificationCodeField;
    }

    public TextField getNewPsswrdFiled1() {
        return newPsswrdFiled1;
    }

    public TextField getNewPsswrdFiled2() {
        return newPsswrdFiled2;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public Button getVerfiyBtn() {
        return verfiyBtn;
    }

    public void setVerfiyBtn(Button verfiyBtn) {
        this.verfiyBtn = verfiyBtn;
    }


    //get email and from the FrogotPsswrd.fxml
    public void storeUsrEmail(){
        setUsrEmail(getUsrEmailField().getText());
    }

    //check first validation in here and,
    //send the mail to the user.java model controller to check in database and get the result boolean
    public boolean isValidEmail(String email) throws SQLException {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches() && systemUser.dbMailChecker(email);
    }

    //set the output in label
    public void usrOutput(String msg){
        getOutputLbl().setText(msg);
    }

    //handle next button clicking
    @FXML
    public void nextBtnClick() throws SQLException, MessagingException {
        storeUsrEmail();
        if(isValidEmail(getUsrEmail())){
            getOutputLbl().setVisible(false);
            System.out.println("valid");
            String code= systemUser.generateVerificationCode();
            System.out.println(code);
            systemUser.dbUpdate(code,getUsrEmail());
            //systemUser.sendEmail(getUsrEmail(),code);
            getVerificationCodeVbox().setDisable(false);
        }
        else{
            getOutputLbl().setVisible(true);
            usrOutput("Invalid email address");
        }
    }

    //handle OTP verification button
    @FXML
    public void verifyOTP() throws SQLException {
        if(systemUser.verifyWithDb(getUsrEmail(),getVerificationCodeField().getText())){
            getVerificationCodeField().setStyle("-fx-border-color: green;-fx-border-width: 2px");
            getOutputLbl().setVisible(true);
            usrOutput("Verified! Now you can enter a new password");
            getnewPsswrdVbox().setDisable(false);
            System.out.println("verified");
        }
        else{
            usrOutput("Incorrect code");
            getVerificationCodeField().setStyle("-fx-border-color: red;-fx-border-width: 2px");
        }

    }

    //get the new password and send to the db
    public void newPsswrd(){
        if(getNewPsswrdFiled1().getText().equals(getNewPsswrdFiled2().getText())){
            getNewPsswrdFiled1().setStyle("-fx-border-color: green;-fx-border-width: 2px");
            getNewPsswrdFiled2().setStyle("-fx-border-color: green;-fx-border-width: 2px");
            systemUser.pswrdChanger();
        }
        else{
            System.out.println("Passwords not matched");
            getNewPsswrdFiled1().setStyle("-fx-border-color: red;-fx-border-width: 2px");
            getNewPsswrdFiled2().setStyle("-fx-border-color: red;-fx-border-width: 2px");
        }
    }



}
