package org.example.hakmana.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Desktop extends Devices{
    private String regNum;
    private String serialNum="NO";
    private String model="NO";
    private String purchasedFrom="NO";
    private String ram="NO";
    private String processor="NO";
    private String warranty="NO";
    private String hardDisk="NO";
    private String os="NO";
    private String status="NO";
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
    private String userName="No User";
    private String floppyDisk="NO";
    private String scannerRegNum="NO";

    public Desktop(String regNum, String serialNum, String model, String purchasedFrom, String ram, String processor, String warranty, String hardDisk, String os, String status,String floppyDisk,String soundCard,String tvCard,String networkCard, String monitorRegNum, String projectorRegNum, String speakerRegNum, String mouseRegNum, String keyboardRegNum, String micRegNum, String scannerRegNum,String userNIC) {
        this.floppyDisk=floppyDisk;
        this.soundCard=soundCard;
        this.tvCard=tvCard;
        this.networkCard=networkCard;
        this.regNum = regNum;
        this.serialNum = serialNum;
        this.model = model;
        this.purchasedFrom = purchasedFrom;
        this.ram = ram;
        this.processor = processor;
        this.warranty = warranty;
        this.hardDisk = hardDisk;
        this.os = os;
        this.status = status;
        this.monitorRegNum = monitorRegNum;
        this.projectorRegNum = projectorRegNum;
        this.speakerRegNum = speakerRegNum;
        this.mouseRegNum = mouseRegNum;
        this.keyboardRegNum = keyboardRegNum;
        this.micRegNum = micRegNum;
        this.scannerRegNum = scannerRegNum;
        this.userNIC=userNIC;
    }
    public Desktop(){

    }

    public Desktop(String regNum, String model, String userName) {
        super(regNum, model, userName);
    }

    public String getUserName() {
        return userName;
    }

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Desktop[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Desktop> desktops = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT desktop.*, user.name FROM desktop LEFT JOIN user ON desktop.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Desktop desktop = new Desktop();
                desktop.setRegNum(resultSet.getString("regNum"));
                desktop.setSerialNum(resultSet.getString("serialNum"));
                desktop.setModel(resultSet.getString("model"));
                desktop.setPurchasedFrom(resultSet.getString("purchasedFrom"));
                desktop.setRam(resultSet.getString("ram"));
                desktop.setProcessor(resultSet.getString("processor"));
                desktop.setWarranty(resultSet.getString("warranty"));
                desktop.setHardDisk(resultSet.getString("hardDisk"));
                desktop.setOs(resultSet.getString("os"));
                desktop.setStatus(resultSet.getString("status"));
                desktop.setMonitorRegNum(resultSet.getString("monitorRegNum"));
                desktop.setProjectorRegNum(resultSet.getString("projectorRegNum"));
                desktop.setSpeakerRegNum(resultSet.getString("speakerRegNum"));
                desktop.setMouseRegNum(resultSet.getString("mouseRegNum"));
                desktop.setKeyboardRegNum(resultSet.getString("keyboardRegNum"));
                desktop.setMicRegNum(resultSet.getString("micRegNum"));
                desktop.setScannerRegNum(resultSet.getString("scannerRegNum"));
                desktop.setUserNIC(resultSet.getString("userNIC"));
                desktop.setFloppyDisk(resultSet.getString("floppyDisk"));
                desktop.setSoundCard(resultSet.getString("soundCard"));
                desktop.setTvCard(resultSet.getString("tvCard"));
                desktop.setNetworkCard(resultSet.getString("networkCard"));
                desktop.setUserName(resultSet.getString("name"));

                desktops.add(desktop);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return desktops.toArray(new Desktop[0]);
    }

}
