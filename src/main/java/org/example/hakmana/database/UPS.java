package org.example.hakmana.database;

public class UPS {
    private String reg_no;
    private String model;
    private String brand;
    private String type;
    private int warrenty;
    private int backup_time;
    private String Serial_no;
    private String status;
    private int battery_size;
    ;

    public int getBattery_size() {
        return battery_size;
    }

    public void setBattery_size(int battery_size) {
        this.battery_size = battery_size;
    }



    public String getReg_no() {
        return reg_no;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public int getWarrenty() {
        return warrenty;
    }

    public int getBackup_time() {
        return backup_time;
    }

    /**
     *
     * @return
     */
    public String getSerial_no() {
        return Serial_no;
    }

    public String getStatus() {
        return status;
    }



    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWarrenty(int warrenty) {
        this.warrenty = warrenty;
    }

    public void setBackup_time(int backup_time) {
        this.backup_time = backup_time;
    }

    public void setSerial_no(String Serial_no) {
        this.Serial_no = Serial_no;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
