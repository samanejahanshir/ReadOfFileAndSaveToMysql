package dao;

import models.Course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AccessDao {
    private Connection connection;

    public AccessDao() throws SQLException, ClassNotFoundException {
        connection = getConnection();
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/readfile", "root", "1234567890");
        }
        return connection;
    }

}
