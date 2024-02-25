package org.example.hakmana.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseConnection {
    private static DatabaseConnection instance =null;
    private Connection connection;
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/hakmanaEdm", "root", "");
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
    public Desktop[] getDesktops() {
        List<Desktop> desktops = new ArrayList<>();
        try {
            String sql = "SELECT desktop.*, user.name FROM desktop LEFT JOIN user ON desktop.userNIC = user.nic";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the SQL query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Desktop desktop = new Desktop();
                desktop.setRegNum(resultSet.getString("regNum"));
                desktop.setSerialNum(resultSet.getString("serialNum"));
                desktop.setModel(resultSet.getString("model"));
                desktop.setPurchasedFrom(resultSet.getString("purchasedFrom"));
                desktop.setRam(resultSet.getString("ram"));
                desktop.setProcessor(resultSet.getString("processor"));
                desktop.setWarranty(resultSet.getString("warranty"));
                desktop.setHardDisk(resultSet.getString("hardDisk"));
                desktop.setOs(resultSet.getString("os"));
                desktop.setStatus(resultSet.getString("status"));
                desktop.setMonitorRegNum(resultSet.getString("monitorRegNum"));
                desktop.setProjectorRegNum(resultSet.getString("projectorRegNum"));
                desktop.setSpeakerRegNum(resultSet.getString("speakerRegNum"));
                desktop.setMouseRegNum(resultSet.getString("mouseRegNum"));
                desktop.setKeyboardRegNum(resultSet.getString("keyboardRegNum"));
                desktop.setMicRegNum(resultSet.getString("micRegNum"));
                desktop.setScannerRegNum(resultSet.getString("scannerRegNum"));
                desktop.setUserNIC(resultSet.getString("userNIC"));
                desktop.setFloppyDisk(resultSet.getString("floppyDisk"));
                desktop.setSoundCard(resultSet.getString("soundCard"));
                desktop.setTvCard(resultSet.getString("tvCard"));
                desktop.setNetworkCard(resultSet.getString("networkCard"));
                desktop.setUserName(resultSet.getString("name"));

                desktops.add(desktop);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return desktops.toArray(new Desktop[0]);
    }

    public User[] getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the SQL query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                User  user = new User();
                user.setNic(resultSet.getString("nic"));
                user.setName(resultSet.getString("name"));
                user.setTitle(resultSet.getString("title"));
                user.setGmail(resultSet.getString("gmail"));


                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users.toArray(new User[0]);
    }

}
