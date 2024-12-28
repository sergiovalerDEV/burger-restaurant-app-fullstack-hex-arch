package model.dao;

import model.motorsql.MotorSQL;
import model.entities.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO implements DAO{

    public ItemDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }
    MotorSQL motorSQL;
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
    public ArrayList getAll() {
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"ITEM\" ORDER BY id ASC");

        ArrayList<Item> arrayList = new ArrayList<>();

        try{
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setImage(resultSet.getString(3));
                item.setIngredients(resultSet.getString(4));
                item.setPrice(resultSet.getInt(5));

                arrayList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
    public ArrayList getAllBurguers(){
        motorSQL.connect();
        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM \"ITEM\" WHERE ID IN (SELECT item FROM \"ITEMCATEGORY\" WHERE category = 1 OR category = 2)");
        ArrayList<Item> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setImage(resultSet.getString(3));
                item.setIngredients(resultSet.getString(4));
                item.setPrice(resultSet.getInt(5));

                arrayList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
    public ArrayList getByCategory(int category){
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"ITEM\" WHERE id IN (SELECT item from \"ITEMCATEGORY\" WHERE category = " + category + ") ORDER BY id ASC");

        ArrayList<Item> arrayList = new ArrayList<>();

        try{
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setImage(resultSet.getString(3));
                item.setIngredients(resultSet.getString(4));
                item.setPrice(resultSet.getInt(5));

                arrayList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<Item> getById(int id){
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"ITEM\" WHERE id = " + id);

        ArrayList<Item> arrayList = new ArrayList<>();

        Item item = new Item();

        try {
            while (resultSet.next()) {
                item = new Item();
                item.setId(resultSet.getInt(1));
                item.setName(resultSet.getString(2));
                item.setImage(resultSet.getString(3));
                item.setIngredients(resultSet.getString(4));
                item.setPrice(resultSet.getInt(5));

                arrayList.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

}