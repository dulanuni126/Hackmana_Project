package org.example.hakmana.model;

public abstract class Devices {
    private String regNum;
    private String model="No";
    private String userName="No User";
    private String status;

    public Devices(String regNum, String model, String userName,String status) {
        this.regNum = regNum;
        this.model = model;
        this.userName = userName;
        this.status=status;
    }

    public Devices() {
    }
    public Devices[] getDevices(){
        return null;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRegNum() {
        return null;
    }
    public String getUserName() {
        return null;
    }
    public String getModel() {
        return null;
    }
    public String getStatus() {
        return null;
    }
}


