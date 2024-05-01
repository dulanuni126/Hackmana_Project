package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UPS extends Devices{
    private String regNum;
    private String model;
    private String status;
    private String userName;
    public UPS(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }
    public UPS() {
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

    public UPS[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
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

}
