package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UPS extends Devices{
    public UPS(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public UPS() {
    }
    public UPS[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<UPS> ups = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT ups.*, user.name FROM ups LEFT JOIN user ON ups.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                UPS ups1 = new UPS();

                ups1.setRegNum(resultSet.getString("regNum"));
                ups1.setModel(resultSet.getString("model"));
                ups1.setStatus(resultSet.getString("status"));

                ups.add(ups1);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return ups.toArray(new UPS[0]);
    }

}
