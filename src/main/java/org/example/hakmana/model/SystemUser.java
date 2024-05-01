package org.example.hakmana.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

public class SystemUser {
    private DatabaseConnection databaseConnection;
    private String userName;
    private String fullName;
    private String post;
    private String empId;
    private String pwd;
    private String email;
    private String phoneNum;
    private boolean isRemember;

    // Constructors
    public SystemUser() {
    }

    public SystemUser(String userName, String fullName, String post, String empId, String pwd, String email, String phoneNum) {
        this.userName = userName;
        this.fullName = fullName;
        this.post = post;
        this.empId = empId;
        this.pwd = pwd;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    // Setters and Getters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isRemember() {
        return isRemember;
    }

    public void setRemember(boolean remember) {
        isRemember = remember;
    }

    @Override
    public String toString() {
        return "SystemUser{" +
                "userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", post='" + post + '\'' +
                ", empId='" + empId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isRemember=" + isRemember +
                '}';
    }

    /*-----------User verification for password reset-------------*/
    //return reultset acording to the user mail
    public ResultSet getResultSet(String mail) throws SQLException {
        String query = "SELECT * FROM systemuser WHERE email = ?";
        databaseConnection=DatabaseConnection.getInstance();
        Connection conn=databaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, mail);
        return ps.executeQuery();
    }

    //check mail in database and return boolean val
    public boolean dbMailChecker(String mail) throws SQLException {
        return getResultSet(mail).next();// return false if result set is empty else (rs not empty)place cursor to the 1 row.
    }
    public boolean verifyWithDb(String mail,String code) throws SQLException {
        ResultSet rs=getResultSet(mail);
        while (rs.next()){
            if(code.equals(rs.getString("verification_code"))){
                System.out.println("code mathced");
                return true;
            }
            else{
                System.out.println("code NOT MATCHED");
            }
        }
        return false;
    }

    //store verification code under the corrected user
    public void dbUpdate(String verificationCode,String mail) throws SQLException {
        String sql = "UPDATE systemuser SET verification_code = ?, code_expiry = DATE_ADD(NOW(), INTERVAL 15 MINUTE) WHERE email = ?"; // Update with expiry time
        databaseConnection=DatabaseConnection.getInstance();
        Connection conn=databaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, verificationCode);
        ps.setString(2, mail);
        ps.executeUpdate();
    }


    //generate verification code
    public String generateVerificationCode() {
        StringBuilder code = new StringBuilder();
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new SecureRandom();
        for (int i = 0; i < 6; i++) { // Adjust code length as needed
            code.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        return code.toString();
    }

    //send the verification code to the email
    public void sendEmail(String recipientEmail, String verificationCode) throws MessagingException {
        String fromEmail = "hakmanaedm@gmail.com"; // sender email
        String host = "smtp.gmail.com"; //SMTP host (e.g., Gmail, Outlook)
        int port = 587; // Replace with your SMTP port
        boolean auth = true; // Authentication required for most free services

        Properties props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS for encryption
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        //getting authentication for email account
        Authenticator authenticator = null;
        if (auth) {
            // Configure authentication if required
            authenticator = new Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail,"hakmanaedm123");
                }
            };
        }

        //start new mail session
        Session session = Session.getInstance(props, authenticator);

        //set the message
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));//set message sender
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));//set message rciever
        message.setSubject("Password Reset Verification Code");

        StringBuilder emailBody = new StringBuilder();
        emailBody.append("\n");
        emailBody.append("You requested a password reset for your account.\n");
        emailBody.append("Your verification code is: ").append(verificationCode).append("\n");
        emailBody.append("Please enter this code in the app to reset your password.\n");
        emailBody.append("This code will expire in 15 minutes.\n");
        emailBody.append("If you did not request a password reset, please ignore this email.\n");

        message.setContent(emailBody.toString(), "text/html; charset=utf-8");

        Transport.send(message);
    }

    //change the new password
    public void pswrdChanger(){
        System.out.println("psswrd changed");
    }
}
