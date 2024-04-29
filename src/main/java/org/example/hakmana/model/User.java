package org.example.hakmana.model;

import javax.mail.*;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class User {
    private DatabaseConnection databaseConnection;
    private String nic;
    private String name;
    private String title;
    private String gmail;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public User() {
    }
    public User(String nic, String name, String title, String gmail) {
        this.nic = nic;
        this.name = name;
        this.title = title;
        this.gmail = gmail;
    }

    /*-----------User verification for password reset-------------*/
    //check mail return boolean val
    public boolean dbMailChecker(String mail) throws SQLException {
        String query = "SELECT * FROM User WHERE gmail = ?";
        databaseConnection=DatabaseConnection.getInstance();
        Connection conn=databaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, mail);
        ResultSet rs=ps.executeQuery();

        // return false if result set is empty else (rs not empty)place cursor to the 1 row.
        return rs.next();
    }

    //store verification code under the corrected user
    public void dbUpdate(PreparedStatement ps,Connection conn,String verificationCode,String mail) throws SQLException {
        String sql = "UPDATE users SET verification_code = ?, code_expiry = DATE_ADD(NOW(), INTERVAL 15 MINUTE) WHERE email = ?"; // Update with expiry time
        ps = conn.prepareStatement(sql);
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
        String fromEmail = "your_email@example.com"; // sender email
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
                    return new PasswordAuthentication(fromEmail,"pasword");
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

    //get verification code and send bool val

    //cahnge the new password
}
