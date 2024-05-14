package org.example.hakmana.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OtherDevices{
    private final DatabaseConnection databaseConnection;
    private static Connection connection;
    private static List<String> excludedTables;
    private static List<String> devices;

    private static boolean devicesLoaded = false;

    //table column values
    private int num;
    private String dev;
    private int totalDev;
    private int numActiveDev;
    private int numInactiveDev;
    private int numRepairingDev;

    //empty constructor for this class
    public OtherDevices() {
        //this list contains the main devices list
        excludedTables = Arrays.asList("desktop","monitors","laptop","printer","ups","multimediaprojector","photocopymachine");

        //store the other devices list
        devices = new ArrayList<>();

        //create the database connection
        databaseConnection = DatabaseConnection.getInstance();
        connection = databaseConnection.getConnection();

    }

    public void setTotalDev(int totalDev) {
        this.totalDev = totalDev;
    }

    public int getNumActiveDev() {
        return numActiveDev;
    }

    public int getNumInactiveDev() {
        return numInactiveDev;
    }

    public int getNumRepairingDev() {
        return numRepairingDev;
    }

    public static List<String> getExcludedTables() {
        return excludedTables;
    }
    public List<String> getDevices() {
        if (!devicesLoaded) {
            // Fetch table names and populate devices list
            fetchTableNames();
            devicesLoaded = true;
        }
        return devices;
    }
    //This method fetch the other devices list from the database
    private static void fetchTableNames(){
        String sql = "SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'hakmanaedm'AND TABLE_NAME NOT IN(";
        for (int i = 0; i < getExcludedTables().size(); i++) {
            sql += "'" + getExcludedTables().get(i) + "'";
            if (i != getExcludedTables().size() - 1) {
                sql += ",";
            }
        }
        sql += ");";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                devices.add(resultSet.getString("TABLE_NAME"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setOtherDeviceTblDetails(String devName) {
        int numActiveDev = 0;
        int numInactiveDev = 0;
        int numRepairingDev = 0;

        try {
            // SQL query without placeholders
            String sqlActive = "SELECT COUNT(*) AS num_active_dev FROM " + devName + " WHERE status = 'active';";
            String sqlInactive = "SELECT COUNT(*) AS num_inactive_dev FROM " + devName + " WHERE status = 'inactive';";
            String sqlRepairing = "SELECT COUNT(*) AS num_repairing_dev FROM " + devName + " WHERE status = 'repairing';";

            // Execute queries for each status
            ResultSet resultSet;

            // Active devices
            PreparedStatement preparedStatementActive = connection.prepareStatement(sqlActive);
            resultSet = preparedStatementActive.executeQuery();
            if (resultSet.next()) {
                numActiveDev = resultSet.getInt("num_active_dev");
            }
            resultSet.close();
            preparedStatementActive.close();

            // Inactive devices
            PreparedStatement preparedStatementInactive = connection.prepareStatement(sqlInactive);
            resultSet = preparedStatementInactive.executeQuery();
            if (resultSet.next()) {
                numInactiveDev = resultSet.getInt("num_inactive_dev");
            }
            resultSet.close();
            preparedStatementInactive.close();

            // Repairing devices
            PreparedStatement preparedStatementRepairing = connection.prepareStatement(sqlRepairing);
            resultSet = preparedStatementRepairing.executeQuery();
            if (resultSet.next()) {
                numRepairingDev = resultSet.getInt("num_repairing_dev");
            }
            resultSet.close();
            preparedStatementRepairing.close();
        } catch (SQLException e) {
            e.getMessage();
        }

        // Print results or use them as needed
        System.out.println("Number of active devices: " + numActiveDev);
        System.out.println("Number of inactive devices: " + numInactiveDev);
        System.out.println("Number of repairing devices: " + numRepairingDev);
    }
}

