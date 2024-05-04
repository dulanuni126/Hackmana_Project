package org.example.hakmana;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.hakmana.model.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getDataController {
    public ObservableList<getNoteController> getNote() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        Connection conn = instance.getConnection();
        ObservableList<getNoteController> list = FXCollections.observableArrayList();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select id,title,createdate from notes");

            while (rs.next()) {
                list.add(new getNoteController(rs.getString(1),rs.getString(2),rs.getDate(3)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
