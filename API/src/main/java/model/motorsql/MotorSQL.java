package model.motorsql;

import java.sql.*;
import java.util.Properties;

public abstract class MotorSQL {
    Properties properties = new Properties();
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String url;
    String user;
    String password;
    String ssl;

    public void connect(){
        System.out.println("llego a motorsql");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            connection = DriverManager.getConnection(url, properties);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    };
    public void disconnect(){
        if(properties != null){
            properties = null;
        }
        if(connection != null){
            connection = null;
        }
        if(statement != null){
            statement = null;
        }
    };
    public ResultSet executeQuery(String query){
        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return  null;
    };
    public void executeStatement(String statement){
        try {
            this.statement = connection.createStatement();
            this.statement.executeUpdate(statement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}
