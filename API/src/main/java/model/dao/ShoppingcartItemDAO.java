package model.dao;

import model.motorsql.MotorSQL;
import model.entities.ShoppingcartItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingcartItemDAO implements DAO<ShoppingcartItem>{
    public ShoppingcartItemDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }

    MotorSQL motorSQL;
    @Override
    public void update(ShoppingcartItem object) {
        motorSQL.connect();
        motorSQL.executeStatement("UPDATE \"SHOPPINGCARTITEM\" SET ammount = " + object.getAmmount() + " WHERE shoppingcart = " + object.getShoppingcart() + " AND item = " + object.getItem());
    }

    public void updateOnlyIngredients(ShoppingcartItem shoppingcartItem) {
        motorSQL.connect();
        motorSQL.executeStatement("UPDATE \"SHOPPINGCARTITEM\" SET ingredients = '" + shoppingcartItem.getIngredients() + "' WHERE shoppingcart = " + shoppingcartItem.getShoppingcart() + " AND item = " + shoppingcartItem.getItem());
        System.out.println("UPDATE \"SHOPPINGCARTITEM\" SET ingredients = '" + shoppingcartItem.getIngredients() + "' WHERE shoppingcart = " + shoppingcartItem.getShoppingcart() + " AND item = " + shoppingcartItem.getItem());
    }

    @Override
    public void add(ShoppingcartItem object) {
        motorSQL.connect();
        motorSQL.executeStatement("INSERT INTO public.\"SHOPPINGCARTITEM\" VALUES (" + object.getShoppingcart() + "," + object.getItem() + " ," + object.getAmmount() + " )");
    }

    @Override
    public void remove() {

    }

    @Override
    public ArrayList getAll() {
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCARTITEM\"");

        ArrayList<ShoppingcartItem> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItem shoppingcartItem = new ShoppingcartItem();
                shoppingcartItem.setShoppingcart(resultSet.getInt(1));
                shoppingcartItem.setItem(resultSet.getInt(2));
                shoppingcartItem.setAmmount(resultSet.getInt(3));

                arrayList.add(shoppingcartItem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<ShoppingcartItem> getByShoppingcart(int shoppingcart) {
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCARTITEM\" WHERE shoppingcart = " + shoppingcart + " AND ammount > 0");

        ArrayList<ShoppingcartItem> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItem shoppingcartItem = new ShoppingcartItem();
                shoppingcartItem.setShoppingcart(resultSet.getInt(1));
                shoppingcartItem.setItem(resultSet.getInt(2));
                shoppingcartItem.setAmmount(resultSet.getInt(3));

                arrayList.add(shoppingcartItem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList getById(int shoppingcart, int item){
        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM \"SHOPPINGCARTITEM\" WHERE \"shoppingcart\" = " + shoppingcart + " AND \"item\" = " + item);

        ArrayList<ShoppingcartItem> arrayList = new ArrayList();

        try {
            while (resultSet.next()) {
                ShoppingcartItem shoppingcartItem = new ShoppingcartItem();
                shoppingcartItem.setShoppingcart(resultSet.getInt(1));
                shoppingcartItem.setItem(resultSet.getInt(2));
                shoppingcartItem.setAmmount(resultSet.getInt(3));
                shoppingcartItem.setIngredients(resultSet.getString(4));

                arrayList.add(shoppingcartItem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<ShoppingcartItem> getByShoppingcartItem(int shoppingcart, int item) {
        System.out.println("Get all shopping cart items for shopping cart: " + shoppingcart);

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCARTITEM\" WHERE shoppingcart = " + shoppingcart);

        ArrayList<ShoppingcartItem> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItem shoppingcartItem = new ShoppingcartItem();
                shoppingcartItem.setShoppingcart(resultSet.getInt(1));
                shoppingcartItem.setItem(resultSet.getInt(2));
                shoppingcartItem.setAmmount(resultSet.getInt(3));

                arrayList.add(shoppingcartItem);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

}