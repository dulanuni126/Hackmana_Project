package org.example.hakmana.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Laptops extends Devices{
    private DatabaseConnection conn;
    private String regNum;
    private String model;
    private String status;
    private String userName;

    private String tech;//including inkjet, laser, and thermal
    private String printSpeed;

    public Laptops(String regNum, String model, String userName, String status, String regNum1, String model1, String userName1, String status1, String tech, String printSpeed) {
        super(regNum, model, userName, status);
        this.tech = tech;
        this.printSpeed = printSpeed;
    }

    public Laptops(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public Laptops() {
    }
    @Override
    public String getRegNum() {
        return regNum;
    }

    @Override
    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getPrintSpeed() {
        return printSpeed;
    }

    public void setPrintSpeed(String printSpeed) {
        this.printSpeed = printSpeed;
    }

    public Laptops[] getDevices() {
        conn=DatabaseConnection.getInstance();
        List<Laptops> laptops = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT laptop.regNum,laptop.model,laptop.status, user.name FROM laptop LEFT JOIN user ON laptop.userNIC = user.userNIC";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Laptops laptop = new Laptops(null,null,null,null);

                laptop.setRegNum(resultSet.getString("regNum"));
                laptop.setModel(resultSet.getString("model"));
                laptop.setStatus(resultSet.getString("status"));
                laptop.setUserName(resultSet.getString("name"));

                laptops.add(laptop);//add laptop to the laptops list
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return laptops.toArray(new Laptops[0]);
    }
    @Override
    public Devices getDevice(String regNum) {
        conn = DatabaseConnection.getInstance();
        //pass query to the connection class
        String sql = "SELECT * FROM laptop Where regNum=?";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, regNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Laptops laptop = new Laptops();
                laptop.setRegNum(rs.getString("regNum"));
                //laptop.setModel(rs.getString("model"));
                //laptop.setStatus(rs.getString("status"));
                //laptop.setUserName(rs.getString("name"));

                return laptop;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }

}
