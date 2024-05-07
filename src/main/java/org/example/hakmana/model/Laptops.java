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

    private String ram = "NO";
    private String cpu = "NO";
    private String storage;
    private String display;
    private String graphicCard="NO";
    private String os = "NO";
    private String userNIC = "No User";

    public Laptops(String regNum, String model, String userName, String status, String ram, String cpu, String storage, String display, String graphicCard, String os, String userNIC) {
        super(regNum, model, userName, status);
        this.ram = ram;
        this.cpu = cpu;
        this.storage = storage;
        this.display = display;
        this.graphicCard = graphicCard;
        this.os = os;
        this.userNIC = userNIC;
    }

    public Laptops(String regNum, String model, String userName, String status) {
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

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getUserNIC() {
        return userNIC;
    }

    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
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
    public Laptops getDevice(String regNum) {
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
                laptop.setModel(rs.getString("model"));
                laptop.setStatus(rs.getString("status"));
                laptop.setRam(rs.getString("RAM"));
                laptop.setCpu(rs.getString("CPU"));
                laptop.setStorage(rs.getString("Storage"));
                laptop.setDisplay(rs.getString("Display"));
                laptop.setGraphicCard(rs.getString("GraphicsCard"));
                laptop.setOs(rs.getString("OperatingSystem"));
                laptop.setUserNIC(rs.getString("userNIC"));

                return laptop;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }

}
