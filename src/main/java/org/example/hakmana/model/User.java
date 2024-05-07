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

public class User {
    private DatabaseConnection dbconn;
    private Connection connection;
    private String nic;
    private String name;
    private String title;
    private String gmail;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public User() {
        dbconn = DatabaseConnection.getInstance();
        connection=dbconn.getConnection();
    }
    public User(String nic, String name, String title, String gmail) {
        dbconn = DatabaseConnection.getInstance();
        connection=dbconn.getConnection();
        this.nic = nic;
        this.name = name;
        this.title = title;
        this.gmail = gmail;
    }
    public User getUser(String userNic) {
        try {
            String sql = "SELECT * FROM user WHERE userNIC=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,userNic);
            // Execute the SQL query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                User  user = new User();

                user.setNic(resultSet.getString("UserNIC"));
                user.setName(resultSet.getString("name"));
                user.setTitle(resultSet.getString("title"));
                user.setGmail(resultSet.getString("gmail"));

                return user;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public User isNicAvailable(String nic) {
        User[] users = getUsers();
        for (User user : users) {
            if (user.getNic().equalsIgnoreCase(nic)) {
                return user;
            }
        }
        return null;
    }
    public User[] getUsers() {
        List<User> users = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Execute the SQL query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate through the result set and create Desktop and User objects
            while (resultSet.next()) {
                User  user = new User();

                user.setNic(resultSet.getString("UserNIC"));
                user.setName(resultSet.getString("name"));
                user.setTitle(resultSet.getString("title"));
                user.setGmail(resultSet.getString("gmail"));


                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users.toArray(new User[0]);
    }
    public void insertUser(ArrayList<String> newUser) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user (userNIC, name, title, gmail) VALUES (?, ?, ?, ?)"
            );
            preparedStatement.setString(1, newUser.get(0));
            preparedStatement.setString(2, newUser.get(1));
            preparedStatement.setString(3, newUser.get(2));
            preparedStatement.setString(4, newUser.get(3));

            preparedStatement.executeUpdate();

            //Check confirmation to change
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("success");
            alert.setContentText("Added new user ");

            Optional<ButtonType> alertResult = alert.showAndWait();//wait until button press in alert box

        } catch (SQLException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding User");
            alert.setHeaderText("An error occurred while adding new user.");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
