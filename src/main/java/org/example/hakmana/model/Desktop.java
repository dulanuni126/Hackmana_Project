package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Desktop extends Devices{
    private String regNum;
    private String model;
    private String status;
    private String userName;

    private String serialNum="NO";
    private String purchasedFrom="NO";
    private String ram="NO";
    private String processor="NO";
    private String warranty="NO";
    private String hardDisk="NO";
    private String os="NO";
    private String monitorRegNum="NO";
    private String projectorRegNum="NO";
    private String speakerRegNum="NO";
    private String mouseRegNum="NO";
    private String keyboardRegNum="NO";
    private String soundCard="NO";
    private String tvCard="NO";
    private String networkCard="NO";
    private String micRegNum="NO";
    private String userNIC="No User";
    private String floppyDisk="NO";
    private String scannerRegNum="NO";

    public Desktop(String regNum,String model,String userName,String status, String serialNum,  String purchasedFrom, String ram, String processor, String warranty, String hardDisk, String os, String floppyDisk,String soundCard,String tvCard,String networkCard, String monitorRegNum, String projectorRegNum, String speakerRegNum, String mouseRegNum, String keyboardRegNum, String micRegNum, String scannerRegNum,String userNIC) {
        super(regNum, model, userName,status);
        this.floppyDisk=floppyDisk;
        this.soundCard=soundCard;
        this.tvCard=tvCard;
        this.networkCard=networkCard;
        this.serialNum = serialNum;
        this.purchasedFrom = purchasedFrom;
        this.ram = ram;
        this.processor = processor;
        this.warranty = warranty;
        this.hardDisk = hardDisk;
        this.os = os;
        this.monitorRegNum = monitorRegNum;
        this.projectorRegNum = projectorRegNum;
        this.speakerRegNum = speakerRegNum;
        this.mouseRegNum = mouseRegNum;
        this.keyboardRegNum = keyboardRegNum;
        this.micRegNum = micRegNum;
        this.scannerRegNum = scannerRegNum;
        this.userNIC=userNIC;
    }

    public Desktop(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public Desktop(){
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

    public String getFloppyDisk() {
        return floppyDisk;
    }

    public void setFloppyDisk(String floppyDisk) {
        this.floppyDisk = floppyDisk;
    }

    public String getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(String soundCard) {
        this.soundCard = soundCard;
    }

    public String getTvCard() {
        return tvCard;
    }

    public void setTvCard(String tvCard) {
        this.tvCard = tvCard;
    }

    public String getNetworkCard() {
        return networkCard;
    }

    public void setNetworkCard(String networkCard) {
        this.networkCard = networkCard;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPurchasedFrom() {
        return purchasedFrom;
    }

    public void setPurchasedFrom(String purchasedFrom) {
        this.purchasedFrom = purchasedFrom;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getMonitorRegNum() {
        return monitorRegNum;
    }

    public void setMonitorRegNum(String monitorRegNum) {
        this.monitorRegNum = monitorRegNum;
    }

    public String getProjectorRegNum() {
        return projectorRegNum;
    }

    public void setProjectorRegNum(String projectorRegNum) {
        this.projectorRegNum = projectorRegNum;
    }

    public String getSpeakerRegNum() {
        return speakerRegNum;
    }

    public void setSpeakerRegNum(String speakerRegNum) {
        this.speakerRegNum = speakerRegNum;
    }

    public String getMouseRegNum() {
        return mouseRegNum;
    }

    public void setMouseRegNum(String mouseRegNum) {
        this.mouseRegNum = mouseRegNum;
    }

    public String getKeyboardRegNum() {
        return keyboardRegNum;
    }

    public void setKeyboardRegNum(String keyboardRegNum) {
        this.keyboardRegNum = keyboardRegNum;
    }

    public String getMicRegNum() {
        return micRegNum;
    }

    public void setMicRegNum(String micRegNum) {
        this.micRegNum = micRegNum;
    }

    public String getScannerRegNum() {
        return scannerRegNum;
    }

    public void setScannerRegNum(String scannerRegNum) {
        this.scannerRegNum = scannerRegNum;
    }

    public String getUserNIC() {
        return userNIC;
    }

    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
    }

    //get the Desktop array from the database
    @Override
    public Desktop[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Desktop> desktops = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT desktop.regNum,desktop.model,desktop.status,user.name FROM desktop LEFT JOIN user ON desktop.userNIC = user.userNIC";

        try(ResultSet resultSet = conn.executeSt(sql)) {// get result set from connection class and auto closable

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Desktop desktop = new Desktop(null,null,null,null);
                desktop.setRegNum(resultSet.getString("regNum"));
                desktop.setModel(resultSet.getString("model"));
                desktop.setStatus(resultSet.getString("status"));
                desktop.setUserName(resultSet.getString("name"));

                desktops.add(desktop);//add desktop to the desktops list
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        //return desktops list as an array
        return desktops.toArray(new Desktop[0]);
    }

}
