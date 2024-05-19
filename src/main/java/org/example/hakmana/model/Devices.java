package org.example.hakmana.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Devices {
    private String regNum;
    private String model="No";
    private String name;
    private String status;


    //get the Devices array from the database
    public Devices[] getDevices(){
        return null;
    }

    public Devices getDevice(String regNum){return null;}

    public abstract void setRegNum(String para1);
    public abstract String getRegNum();

    public abstract void setModel(String para1);
    public abstract String getModel();

    public abstract String getUserName();
    public abstract void setUserName(String para1);

    public abstract void setStatus(String para1);
    public abstract String getStatus();

}


