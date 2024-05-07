package org.example.hakmana.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Monitors extends Devices{
    private DatabaseConnection conn;
    private String regNum;
    private String model;
    private String status;
    private String userName;
    private String screenSize;
    private String userNIC = "No User";
    private String regNumDesktop="no desktop";

    public Monitors(String regNum, String model, String userName, String status, String screenSize, String userNIC, String regNumDesktop) {
        super(regNum, model, userName, status);
        this.screenSize = screenSize;
        this.userNIC = userNIC;
        this.regNumDesktop = regNumDesktop;
    }

    public Monitors(String regNum, String model, String userName, String status) {
        super(regNum, model, userName,status);
    }

    public Monitors() {
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

    public String getScreenSize() {
        return screenSize;
    }
    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
    public String getUserNIC() {
        return userNIC;
    }
    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
    }
    public String getRegNumDesktop() {
        return regNumDesktop;
    }
    public void setRegNumDesktop(String regNumDesktop) {
        this.regNumDesktop = regNumDesktop;
    }

    public Monitors[] getDevices() {
        conn=DatabaseConnection.getInstance();
        List<Monitors> monitors = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT monitors.regNum,monitors.model,monitors.status, user.name FROM monitors LEFT JOIN user ON monitors.userNIC = user.userNIC";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Monitors monitor = new Monitors(null,null,null,null);

                monitor.setRegNum(resultSet.getString("regNum"));
                monitor.setModel(resultSet.getString("model"));
                monitor.setStatus(resultSet.getString("status"));
                monitor.setUserName(resultSet.getString("name"));


                monitors.add(monitor);//add monitor to the monitors list
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return monitors.toArray(new Monitors[0]);
    }
    @Override
    public Monitors getDevice(String regNum) {
        conn = DatabaseConnection.getInstance();
        //pass query to the connection class
        String sql = "SELECT * FROM monitors Where regNum=?";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, regNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Monitors monitors = new Monitors();
                monitors.setRegNum(rs.getString("regNum"));
                monitors.setModel(rs.getString("model"));
                monitors.setStatus(rs.getString("status"));
                monitors.setUserNIC(rs.getString("userNIC"));
                monitors.setRegNumDesktop(rs.getString("regNumDesktop"));

                return monitors;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }
}
