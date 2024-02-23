package org.example.hakmana.database;

public class Desktop {
    private String reg_no;
    private String serial_no;
    private String model;
    private String status;
    private String brand;
    private String processor;
    private String ram;
    private String harddisk;
    private String CD_rom;
    private String Sound_card;
    private int warrenty;
    private int time;

    public String getReg_no() {
        return reg_no;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public String getModel() {
        return model;
    }

    public String getStatus() {
        return status;
    }

    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public String getRam() {
        return ram;
    }

    public String getHarddisk() {
        return harddisk;
    }

    public String getCD_rom() {
        return CD_rom;
    }

    public String getSound_card() {
        return Sound_card;
    }

    public int getWarrenty() {
        return warrenty;
    }

    public int getTime() {
        return time;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk = harddisk;
    }

    public void setCD_rom(String CD_rom) {
        this.CD_rom = CD_rom;
    }

    public void setSound_card(String Sound_card) {
        this.Sound_card = Sound_card;
    }

    public void setWarrenty(int warrenty) {
        this.warrenty = warrenty;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
