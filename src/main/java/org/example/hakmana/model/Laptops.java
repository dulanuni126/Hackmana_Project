package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Laptops extends Devices{

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
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Laptops> laptops = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT laptop.*, user.name FROM desktop LEFT JOIN user ON laptop.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Laptops laptop = new Laptops();

                laptop.setRegNum(resultSet.getString("regNum"));
                laptop.setModel(resultSet.getString("model"));
                laptop.setStatus(resultSet.getString("status"));
                laptop.setUserName(resultSet.getString("name"));

                laptop.setTech(resultSet.getString("tech"));
                laptop.setPrintSpeed(resultSet.getString("printSpeed"));

                laptops.add(laptop);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return laptops.toArray(new Laptops[0]);
    }

}
