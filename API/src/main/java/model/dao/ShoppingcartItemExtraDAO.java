package model.dao;

import model.motorsql.MotorSQL;
import model.entities.ShoppingcartItemExtra;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingcartItemExtraDAO implements DAO<ShoppingcartItemExtra>{
    private final MotorSQL motorSQL;

    public ShoppingcartItemExtraDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }

    @Override
    public void update(ShoppingcartItemExtra object) {
        motorSQL.connect();
        String query = "UPDATE \"SHOPPINGCARTITEMEXTRA\" SET ammount = " + object.getAmmount() +
                " WHERE shoppingcartItem = " + object.getShoppingcartItem() +
                " AND extra = " + object.getExtra();
        motorSQL.executeStatement(query);
    }

    @Override
    public void add(ShoppingcartItemExtra object) {
        motorSQL.connect();
        String query = "INSERT INTO public.\"SHOPPINGCARTITEMEXTRA\" (extra, amount, shoppingcartItem) VALUES (" +
                object.getExtra() + ", " + object.getAmmount() + ", " + object.getShoppingcartItem() + ")";
        motorSQL.executeStatement(query);
    }

    @Override
    public void remove() {
        // Implement the remove method as needed
    }

    @Override
    public ArrayList<ShoppingcartItemExtra> getAll() {
        motorSQL.connect();
        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCARTITEMEXTRA\"");
        ArrayList<ShoppingcartItemExtra> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItemExtra shoppingcartItemExtra = new ShoppingcartItemExtra();
                shoppingcartItemExtra.setExtra(resultSet.getInt(1));
                shoppingcartItemExtra.setAmmount(resultSet.getInt(2));
                shoppingcartItemExtra.setShoppingcartItem(resultSet.getInt(3));

                arrayList.add(shoppingcartItemExtra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<ShoppingcartItemExtra> getByShoppingcartItem(int shoppingcartItem) {
        motorSQL.connect();
        String query = "SELECT * FROM public.\"SHOPPINGCARTITEMEXTRA\" WHERE shoppingcartItem = " + shoppingcartItem;
        ResultSet resultSet = motorSQL.executeQuery(query);
        ArrayList<ShoppingcartItemExtra> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItemExtra shoppingcartItemExtra = new ShoppingcartItemExtra();
                shoppingcartItemExtra.setExtra(resultSet.getInt(1));
                shoppingcartItemExtra.setAmmount(resultSet.getInt(2));
                shoppingcartItemExtra.setShoppingcartItem(resultSet.getInt(3));

                arrayList.add(shoppingcartItemExtra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<ShoppingcartItemExtra> getByShoppingcartItemExtra(int shoppingcartItem, int extra) {
        motorSQL.connect();
        String query = "SELECT * FROM public.\"SHOPPINGCARTITEMEXTRA\" WHERE shoppingcartItem = " + shoppingcartItem +
                " AND extra = " + extra;
        ResultSet resultSet = motorSQL.executeQuery(query);
        ArrayList<ShoppingcartItemExtra> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                ShoppingcartItemExtra shoppingcartItemExtra = new ShoppingcartItemExtra();
                shoppingcartItemExtra.setExtra(resultSet.getInt(1));
                shoppingcartItemExtra.setAmmount(resultSet.getInt(2));
                shoppingcartItemExtra.setShoppingcartItem(resultSet.getInt(3));

                arrayList.add(shoppingcartItemExtra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
}
