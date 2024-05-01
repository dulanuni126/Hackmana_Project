package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebCam extends Devices{
    private String regNum;
    private String model;
    private String status;
    private String userName;
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

    public WebCam(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public WebCam() {
    }

    public WebCam[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<WebCam> webCams = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT webCam.*, user.name FROM webCam LEFT JOIN user ON webCam.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                WebCam webCam = new WebCam();

                webCam.setRegNum(resultSet.getString("regNum"));
                webCam.setModel(resultSet.getString("model"));
                webCam.setStatus(resultSet.getString("status"));

                webCams.add(webCam);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return webCams.toArray(new WebCam[0]);
    }
}
