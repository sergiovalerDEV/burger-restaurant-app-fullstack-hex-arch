package model.dao;

import model.motorsql.MotorSQL;
import model.entities.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAO{
    MotorSQL motorSQL;
    public CategoryDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }
    @Override
    public void update(Object object) {

    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void remove() {

    }

    @Override
    public ArrayList<Category> getAll() {
        System.out.println("Get all the categories");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"CATEGORY\"");

        ArrayList<Category> arrayList = new ArrayList<>();

        try{
            while(resultSet.next()){
                Category category = new Category();
                category.setId(resultSet.getInt(1));
                category.setName(resultSet.getString(2));
                category.setImg(resultSet.getString(3));

                arrayList.add(category);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arrayList;
    }
}