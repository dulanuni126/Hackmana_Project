package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhotocpyMchine extends Devices{

    private String copyingCapability;// either in black and white or color

    public PhotocpyMchine(String regNum, String model, String userName, String status, String copyingCapability) {
        super(regNum, model, userName, status);
        this.copyingCapability = copyingCapability;
    }

    public PhotocpyMchine(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public PhotocpyMchine() {
    }

    public String getCopyingCapability() {
        return copyingCapability;
    }

    public void setCopyingCapability(String copyingCapability) {
        this.copyingCapability = copyingCapability;
    }

    public PhotocpyMchine[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<PhotocpyMchine> photocpyMchines = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT photocpyMchine.*, user.name FROM photocpyMchine LEFT JOIN user ON photocpyMchine.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                PhotocpyMchine photocpyMchine = new PhotocpyMchine();

                photocpyMchine.setRegNum(resultSet.getString("regNum"));
                photocpyMchine.setModel(resultSet.getString("model"));
                photocpyMchine.setStatus(resultSet.getString("status"));
                photocpyMchine.setUserName(resultSet.getString("name"));

                photocpyMchine.setCopyingCapability(resultSet.getString("copyingCapability"));

                photocpyMchines.add(photocpyMchine);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return photocpyMchines.toArray(new PhotocpyMchine[0]);
    }
}
