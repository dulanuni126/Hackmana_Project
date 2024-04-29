package org.example.hakmana.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Projectors extends Devices{
    public Projectors(String regNum, String model, String userName, String status) {
        super(regNum, model, userName, status);
    }

    public Projectors() {
    }

    public Projectors[] getDevices() {
        DatabaseConnection conn=DatabaseConnection.getInstance();
        List<Projectors> projectors = new ArrayList<>();
        //pass query to the connection class
        String sql = "SELECT projector.*, user.name FROM projector LEFT JOIN user ON projector.userNIC = user.nic";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Projectors projector = new Projectors();

                projector.setRegNum(resultSet.getString("regNum"));
                projector.setModel(resultSet.getString("model"));
                projector.setStatus(resultSet.getString("status"));

                projectors.add(projector);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return projectors.toArray(new Projectors[0]);
    }
}
