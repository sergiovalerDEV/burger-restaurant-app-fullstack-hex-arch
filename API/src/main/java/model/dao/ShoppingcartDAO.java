package model.dao;

import model.motorsql.MotorSQL;
import model.entities.Shoppingcart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingcartDAO implements DAO<Shoppingcart>{
    public ShoppingcartDAO(MotorSQL motorSQL){
        this.motorSQL = motorSQL;
    }
    MotorSQL motorSQL;
    @Override
    public void update(Shoppingcart object) {
        motorSQL.connect();
        motorSQL.executeStatement("UPDATE public.\"SHOPPINGCART\" SET price=" + object.getPrice() + ", opened=" + object.isOpened() + " WHERE id=" + object.getId());
    }

    @Override
    public void add(Shoppingcart object) {
        motorSQL.connect();
        //System.out.println("INSERT INTO public.\"SHOPPINGCART\" (\"user\", price, date, opened) VALUES (" + object.getUser() + ", 0, CURRENT_DATE, true)");
        motorSQL.executeStatement("INSERT INTO public.\"SHOPPINGCART\" (\"user\", price, date, opened) VALUES (" + object.getUser() + ", 0, CURRENT_DATE, true)");
    }

    @Override
    public void remove() {

    }

    @Override
    public ArrayList getAll() {
        return null;
    }
    public ArrayList getOpenedByUser(int user) {
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCART\" WHERE \"user\" = " + user + " AND opened = true");

        ArrayList<Shoppingcart> arrayList = new ArrayList<>();

        try{
            while (resultSet.next()) {
                Shoppingcart shoppingcart = new Shoppingcart();
                shoppingcart.setId(resultSet.getInt(1));
                shoppingcart.setUser(resultSet.getInt(2));
                shoppingcart.setPrice(resultSet.getString(3));
                shoppingcart.setDate(resultSet.getString(4));
                shoppingcart.setOpened(resultSet.getString(5));

                arrayList.add(shoppingcart);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList getClosedByUser(int user) {
        System.out.println("Get all the burgers");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"SHOPPINGCART\" WHERE \"user\" = " + user + " AND opened = false");

        ArrayList<Shoppingcart> arrayList = new ArrayList<>();

        try{
            while (resultSet.next()) {
                Shoppingcart shoppingcart = new Shoppingcart();
                shoppingcart.setId(resultSet.getInt(1));
                shoppingcart.setUser(resultSet.getInt(2));
                shoppingcart.setPrice(resultSet.getString(3));
                shoppingcart.setDate(resultSet.getString(4));
                shoppingcart.setOpened(resultSet.getString(5));

                arrayList.add(shoppingcart);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
}