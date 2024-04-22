package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Printer extends Devices {
    private String regNum;
    private String serialNum;
    private String paperInput;
    private String paperOutput;
    private String warranty;
    private String model;
    private String status;
    private String userNIC;

    public Printer(String regNum, String model, String userName) {
        super(regNum, model, userName);
    }

    public Printer(String regNum, String serialNum, String paperInput, String paperOutput, String warranty, String model, String status, String userNIC) {
        this.regNum = regNum;
        this.serialNum = serialNum;
        this.paperInput = paperInput;
        this.paperOutput = paperOutput;
        this.warranty = warranty;
        this.model = model;
        this.status = status;
        this.userNIC = userNIC;
    }

    public Printer() {
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        String sql = "SELECT printer.* FROM printer";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Printer printer = new Printer();
                printer.setRegNum(resultSet.getString("regNum"));
                printer.setSerialNum(resultSet.getString("serialNum"));
                printer.setModel(resultSet.getString("model"));
                printer.setStatus(resultSet.getString("status"));
                //printer.setUserName(resultSet.getString("name"));
                printer.setPaperInput(resultSet.getString("PaperInput"));
                printer.setPaperOutput(resultSet.getString("PaperOutput"));
                printer.setWarranty(resultSet.getString("Warranty"));
                printer.setUserNIC(resultSet.getString("UserNIC"));

                printers.add(printer);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return printers.toArray(new Printer[0]);
    }
}
