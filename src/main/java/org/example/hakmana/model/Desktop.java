package org.example.hakmana.model;

public class Desktop {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String floppyDisk="NO";
    private String scannerRegNum="NO";


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



}
