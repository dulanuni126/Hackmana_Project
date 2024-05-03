package org.example.hakmana;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.hakmana.model.DatabaseConnection;

import java.sql.*;

public class getNoteController {
    private String id;
    private String title;
    private Date date;

    public getNoteController(String id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;

    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }


}


