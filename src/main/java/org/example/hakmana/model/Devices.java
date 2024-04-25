package org.example.hakmana.model;

public abstract class Devices {
    private String regNum;
    private String model="No";
    private String userName="No User";

    public Devices(String regNum, String model, String userName) {
        this.regNum = regNum;
        this.model = model;
        this.userName = userName;
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

    public String getRegNum() {
        return null;
    }
    public String getUserName() {
        return null;
    }
    public String getModel() {
        return null;
    }
}


