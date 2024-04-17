package org.example.hakmana.model;

public class Printer {
    private String regNum;
    private String serialNum;
    private String paperInput;
    private String paperOutput;
    private String warranty;
    private String model;
    private String status;
    private String userNIC;

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
}
