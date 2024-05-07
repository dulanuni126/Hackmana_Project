package org.example.hakmana.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UPS extends Devices{
    private DatabaseConnection conn;
    private String regNum;
    private String model;
    private String status;
    private String userName;

    private String backUpPower;
    private String runTime;
    private String regNumDesktop;

    public UPS(String regNum, String model, String userName, String status, String backUpPower, String runTime, String regNumDesktop) {
        super(regNum, model, userName, status);
        this.backUpPower = backUpPower;
        this.runTime = runTime;
        this.regNumDesktop = regNumDesktop;
    }

    public UPS(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }
    public UPS() {}
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

    public String getBackUpPower() {
        return backUpPower;
    }

    public void setBackUpPower(String backUpPower) {
        this.backUpPower = backUpPower;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    public String getRegNumDesktop() {
        return regNumDesktop;
    }

    public void setRegNumDesktop(String regNumDesktop) {
        this.regNumDesktop = regNumDesktop;
    }

    public UPS[] getDevices() {
       conn=DatabaseConnection.getInstance();
        List<UPS> ups = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT * FROM ups";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                UPS ups1 = new UPS(null,null,null,null);

                ups1.setRegNum(resultSet.getString("regNum"));
                ups1.setModel(resultSet.getString("model"));
                ups1.setStatus(resultSet.getString("status"));

                ups.add(ups1);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return ups.toArray(new UPS[0]);
    }
    @Override
    public UPS getDevice(String regNum) {
        conn = DatabaseConnection.getInstance();
        //pass query to the connection class
        String sql = "SELECT * FROM ups Where regNum=?";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, regNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UPS ups = new UPS();
                ups.setRegNum(rs.getString("regNum"));
                ups.setModel(rs.getString("model"));
                ups.setStatus(rs.getString("status"));
                ups.setBackUpPower(rs.getString("BackupPower"));
                ups.setRunTime(rs.getString("Runtime"));
                ups.setRegNumDesktop(rs.getString("regNumDesktop"));

                return ups;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }

}
