package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Projectors extends Devices{
    private String regNum;
    private String model;
    private String status;
    private String userName;
    public Projectors(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public Projectors() {
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

    public Projectors[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Projectors> projectors = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT * FROM multimediaprojector";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Projectors projector = new Projectors(null,null,null,null);

                projector.setRegNum(resultSet.getString("regNum"));
                projector.setModel(resultSet.getString("model"));
                projector.setStatus(resultSet.getString("status"));
                projector.setUserName("no user");

                projectors.add(projector);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return projectors.toArray(new Projectors[0]);
    }
}
