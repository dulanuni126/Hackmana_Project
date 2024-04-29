package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhotocpyMchine extends Devices {
    private String CopyingCapability;

    public PhotocpyMchine(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public PhotocpyMchine() {
    }

    public String getCopyingCapability() {
        return CopyingCapability;
    }

    public void setCopyingCapability(String copyingCapability) {
        CopyingCapability = copyingCapability;
    }
@Override
public Devices[] getDevices() {
    DatabaseConnection conn=DatabaseConnection.getInstance();
    List<PhotocpyMchine> photocopyMachines = new ArrayList<>();
    //pass query to the connection class
    String sql = "SELECT PhotoCopyMachine.* FROM PhotoCopyMachine";

    try {
        // get result set from connection class
        ResultSet resultSet = conn.executeSt(sql);

        // Iterate through the result set and create Desktop and User objects
        while (resultSet.next()) {
            PhotocpyMchine photocopyMachine = new PhotocpyMchine();
            photocopyMachine.setRegNum(resultSet.getString("regNum"));
            photocopyMachine.setModel(resultSet.getString("model"));
            photocopyMachines.add(photocopyMachine);
        }
    }
    catch (SQLException e){
        throw new RuntimeException(e);
    }

    return photocopyMachines.toArray(new PhotocpyMchine[0]);
}
}
