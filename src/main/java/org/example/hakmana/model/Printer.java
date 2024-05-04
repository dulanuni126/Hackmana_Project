package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Printer extends Devices {
    private String regNum;
    private String model;
    private String status;
    private String userName;
    private String serialNum;
    private String paperInput;
    private String paperOutput;
    private String warranty;
    private String userNIC;

    public Printer(String regNum, String model, String userName,String status,String serialNum, String paperInput, String paperOutput, String warranty, String userNIC) {
        super(regNum, model, userName,status);
        this.serialNum = serialNum;
        this.paperInput = paperInput;
        this.paperOutput = paperOutput;
        this.warranty = warranty;
        this.userNIC = userNIC;
    }

    public Printer(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public Printer() {
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
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPaperInput() {
        return paperInput;
    }

    public void setPaperInput(String paperInput) {
        this.paperInput = paperInput;
    }

    public String getPaperOutput() {
        return paperOutput;
    }

    public void setPaperOutput(String paperOutput) {
        this.paperOutput = paperOutput;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getUserNIC() {
        return userNIC;
    }

    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
    }
    public Printer[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Printer> printers = new ArrayList<>();
        //pass query to the connection class
        String sql = "ELECT printer.regNum,printer.model,printer.status, user.name FROM printer LEFT JOIN user ON printer.userNIC = user.userNIC";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Printer printer = new Printer(null,null,null,null);
                printer.setRegNum(resultSet.getString("regNum"));
                printer.setModel(resultSet.getString("model"));
                printer.setStatus(resultSet.getString("status"));
                printer.setUserName(resultSet.getString("name"));

                printers.add(printer);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return printers.toArray(new Printer[0]);
    }
}
