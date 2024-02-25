package org.example.hakmana.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DatabaseConnection {
    private static DatabaseConnection instance =null;
    private Connection connection;
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hakmanaEdm", "root", "root1234");
            System.out.println("Connection Successfully");

        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance= new DatabaseConnection();
            return instance;
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }

    public void insertDesktop(Desktop desktop) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO desktop (regNum, serialNum, model, purchasedFrom, ram, processor, warranty, hardDisk, os, status, floppyDisk, soundCard, tvCard, networkCard, monitorRegNum, projectorRegNum, speakerRegNum, mouseRegNum, keyboardRegNum, micRegNum, scannerRegNum, userNIC) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setString(1, desktop.getRegNum());
            preparedStatement.setString(2, desktop.getSerialNum());
            preparedStatement.setString(3, desktop.getModel());
            preparedStatement.setString(4, desktop.getPurchasedFrom());
            preparedStatement.setString(5, desktop.getRam());
            preparedStatement.setString(6, desktop.getProcessor());
            preparedStatement.setString(7, desktop.getWarranty());
            preparedStatement.setString(8, desktop.getHardDisk());
            preparedStatement.setString(9, desktop.getOs());
            preparedStatement.setString(10, desktop.getStatus());
            preparedStatement.setString(11, desktop.getFloppyDisk());
            preparedStatement.setString(12, desktop.getSoundCard());
            preparedStatement.setString(13, desktop.getTvCard());
            preparedStatement.setString(14, desktop.getNetworkCard());
            preparedStatement.setString(15, desktop.getMonitorRegNum());
            preparedStatement.setString(16, desktop.getProjectorRegNum());
            preparedStatement.setString(17, desktop.getSpeakerRegNum());
            preparedStatement.setString(18, desktop.getMouseRegNum());
            preparedStatement.setString(19, desktop.getKeyboardRegNum());
            preparedStatement.setString(20, desktop.getMicRegNum());
            preparedStatement.setString(21, desktop.getScannerRegNum());
            preparedStatement.setString(22, desktop.getUserNIC());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user (nic, name, title, gmail) VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setString(1, user.getNic());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getTitle());
            preparedStatement.setString(4, user.getGmail());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
