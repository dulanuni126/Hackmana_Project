package org.example.hakmana.model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Printer extends Devices {
    private DatabaseConnection conn;
    private String regNum;
    private String model;
    private String status;
    private String userName;
    private String serialNum;
    private String paperInput;
    private String paperOutput;
    private String warranty;
    private String userNIC;

    public Printer(String regNum, String model, String userName,String status,String serialNum, String paperInput, String paperOutput, String warranty, String userNIC) {
        super(regNum, model, userName,status);
        this.serialNum = serialNum;
        this.paperInput = paperInput;
        this.paperOutput = paperOutput;
        this.warranty = warranty;
        this.userNIC = userNIC;
    }

    public Printer(String regNum, String model, String userName,String status) {
        super(regNum, model, userName,status);
    }

    public Printer() {
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
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPaperInput() {
        return paperInput;
    }

    public void setPaperInput(String paperInput) {
        this.paperInput = paperInput;
    }

    public String getPaperOutput() {
        return paperOutput;
    }

    public void setPaperOutput(String paperOutput) {
        this.paperOutput = paperOutput;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getUserNIC() {
        return userNIC;
    }

    public void setUserNIC(String userNIC) {
        this.userNIC = userNIC;
    }
    public Printer[] getDevices() {
        conn=DatabaseConnection.getInstance();
        List<Printer> printers = new ArrayList<>();
        //pass query to the connection class
        String sql = "ELECT printer.regNum,printer.model,printer.status, user.name FROM printer LEFT JOIN user ON printer.userNIC = user.userNIC";

        try {
            // get result set from connection class
            ResultSet resultSet = conn.executeSt(sql);

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                Printer printer = new Printer(null,null,null,null);
                printer.setRegNum(resultSet.getString("regNum"));
                printer.setModel(resultSet.getString("model"));
                printer.setStatus(resultSet.getString("status"));
                printer.setUserName(resultSet.getString("name"));

                printers.add(printer);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }

        return printers.toArray(new Printer[0]);
    }
    @Override
    public Printer getDevice(String regNum) {
        conn = DatabaseConnection.getInstance();
        //pass query to the connection class
        String sql = "SELECT * FROM printer Where regNum=?";

        try {
            PreparedStatement ps = conn.getConnection().prepareStatement(sql);
            ps.setString(1, regNum);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Printer printer = new Printer();
                printer.setRegNum(rs.getString("regNum"));
                printer.setModel(rs.getString("model"));
                printer.setStatus(rs.getString("status"));
                printer.setSerialNum(rs.getString("serialNum"));
                printer.setPaperInput(rs.getString("paperInput"));
                printer.setPaperOutput(rs.getString("paperOutput"));
                printer.setWarranty(rs.getString("warranty"));
                printer.setUserNIC(rs.getString("userNIC"));

                return printer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //return null if there is no result
        return null;
    }
    public boolean updateDevice(ArrayList<String> list){
        conn = DatabaseConnection.getInstance();
        Connection connection= conn.getConnection();
        //pass query to the connection class
        String sql="UPDATE printer SET model=?,status=?,serialNum=?,paperInput=?,paperOutput=?,warranty=? WHERE regNUM=?";
        try {
            connection.setAutoCommit(false);

            int i=1;
            PreparedStatement ps = connection.prepareStatement(sql);
            for(String l:list){
                ps.setString(i,l);
                i++;
            }

            i=ps.executeUpdate();

            //Check confirmation to change
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Update "+ i+" rows desktop registration number " +list.get(6));

            Optional<ButtonType> alertResult = alert.showAndWait();//wait until button press in alert box

            //if alert box ok pressed execute sql quires
            if (alertResult.isPresent() && alertResult.get() == ButtonType.OK) {
                // commit the sql quires
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            } else {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

        } catch (SQLException e) {
            // Rollback the transaction on error
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Updating Device");
            alert.setHeaderText("An error occurred while updating the device.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return false;
    }
}
