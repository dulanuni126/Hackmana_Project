package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Monitors extends Devices{

    private String screenSize;

    public Monitors(String regNum, String model, String userName, String status, String screenSize, String status1, String userName1, String model1, String regNum1) {
        super(regNum, model, userName, status);
        this.screenSize = screenSize;
    }

    public Monitors(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public Monitors() {
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public Monitors[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Monitors> monitors = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT moniter.*, user.name FROM moniter LEFT JOIN user ON moniter.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Monitors monitor = new Monitors();

                monitor.setRegNum(resultSet.getString("regNum"));
                monitor.setModel(resultSet.getString("model"));
                monitor.setStatus(resultSet.getString("status"));
                monitor.setUserName(resultSet.getString("name"));

                monitor.setScreenSize(resultSet.getString("screenSize"));

                monitors.add(monitor);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return monitors.toArray(new Monitors[0]);
    }
}
