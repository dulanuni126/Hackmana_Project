package org.example.hakmana;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.hakmana.model.User;

import javax.mail.MessagingException;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class ForgotPasswrdController {
    public User userModelCls=new User();
    private String usrEmail;

    //injectors for fxml components
    @FXML
    private VBox usrMailVbox,verificationCodeVbox,newEmailVbox;
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

    public VBox getNewEmailVbox() {
        return newEmailVbox;
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
        return pattern.matcher(email).matches() && userModelCls.dbMailChecker(email);
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
            System.out.println("valid");
            String code=userModelCls.generateVerificationCode();
            System.out.println(code);
            userModelCls.dbUpdate(code,getUsrEmail());
            //userModelCls.sendEmail(getUsrEmail(),code);
            getVerificationCodeVbox().setDisable(false);
        }
        else{
            getOutputLbl().setVisible(true);
            usrOutput("Invalid email address");
        }
    }

    @FXML
    public void verifyOTP(){
        if(getVerificationCodeField().getText().equals("")){
            usrOutput("Verified");
            System.out.println("verified");
        }
        else{
            usrOutput("Incorrect code");
        }

    }
    //send verification code and timer to expire as a query yot the db

    //and timer update

    //disable all other except new password entering field

    //get the new password and send to the db


}
