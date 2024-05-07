package org.example.hakmana.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhotocpyMchine extends Devices {
    private DatabaseConnection conn;
    private String regNum;
    private String model;
    private String status;
    private String userName;
    private String CopyingCapability;

    public PhotocpyMchine(String regNum, String model, String userName, String status, String copyingCapability) {
        super(regNum, model, userName, status);
        CopyingCapability = copyingCapability;
    }

    public PhotocpyMchine(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public PhotocpyMchine() {
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

    public String getCopyingCapability() {
        return CopyingCapability;
    }

    public void setCopyingCapability(String copyingCapability) {
        CopyingCapability = copyingCapability;
    }
    @Override
    public PhotocpyMchine[] getDevices() {
       conn=DatabaseConnection.getInstance();
        List<PhotocpyMchine> photocopyMachines = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT PhotoCopyMachine.* FROM PhotoCopyMachine";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                PhotocpyMchine photocopyMachine = new PhotocpyMchine(null,null,null,null);
                photocopyMachine.setRegNum(resultSet.getString("regNum"));
                photocopyMachine.setModel(resultSet.getString("model"));
                photocopyMachine.setUserName("no user");

                photocopyMachines.add(photocopyMachine);//add photocopyMachines to the photocopyMachins list
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

        return photocopyMachines.toArray(new PhotocpyMchine[0]);
    }
    @Override
    public PhotocpyMchine getDevice(String regNum) {
        conn = DatabaseConnection.getInstance();
        //pass query to the connection class
        String sql = "SELECT * FROM PhotoCopyMachine Where regNum=?";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, regNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PhotocpyMchine PhotoCopyMachine = new PhotocpyMchine();
                PhotoCopyMachine.setRegNum(rs.getString("regNum"));
                PhotoCopyMachine.setModel(rs.getString("model"));
                PhotoCopyMachine.setStatus(rs.getString("status"));
                PhotoCopyMachine.setCopyingCapability(rs.getString("CopyingCapability"));

                return PhotoCopyMachine;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }
}
