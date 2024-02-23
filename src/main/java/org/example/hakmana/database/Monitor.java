package org.example.hakmana.database;

public class Monitor {
    private String reg_no;
    private String model;
    private String brand;
    private String status;
    private String Screen_type;
    private int warrenty;

    public String getReg_no() {
        return reg_no;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getStatus() {
        return status;
    }

    public String getScreen_type() {
        return Screen_type;
    }

    public int getWarrenty() {
        return warrenty;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setScreen_type(String Screen_type) {
        this.Screen_type = Screen_type;
    }

    public void setWarrenty(int warrenty) {
        this.warrenty = warrenty;
    }


}
