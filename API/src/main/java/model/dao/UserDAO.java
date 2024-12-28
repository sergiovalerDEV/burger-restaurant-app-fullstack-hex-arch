package model.dao;

import model.motorsql.MotorSQL;
import model.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements DAO<User>{
    public UserDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }

    MotorSQL motorSQL;

    @Override
    public void update(User object) {

    }

    @Override
    public void add(User object) {
        System.out.println("Add one user");
        motorSQL.connect();
        motorSQL.executeStatement("INSERT INTO public.\"USER\" (name, address, password) VALUES ('" + object.getName() + "', '" + object.getAddress() + "', '" + object.getPassword() + "')");

    }

    @Override
    public void remove() {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }

    public ArrayList getByName(String name){
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"USER\" WHERE name = '" + name + "'");

        ArrayList<User> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setAddress(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));

                arrayList.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
}