package model.dao;

import model.motorsql.MotorSQL;
import model.entities.Extra;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExtraDAO implements DAO {

    public ExtraDAO(MotorSQL motorSQL) {
        this.motorSQL = motorSQL;
    }

    MotorSQL motorSQL;

    @Override
    public void update(Object object) {
        // Implementación para actualizar un extra en la base de datos
    }

    @Override
    public void add(Object object) {
        // Implementación para agregar un extra a la base de datos
    }

    @Override
    public void remove() {
        // Implementación para eliminar un extra de la base de datos
    }

    @Override
    public ArrayList getAll() {
        System.out.println("Obteniendo todos los extras");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"EXTRA\" ORDER BY id ASC");

        ArrayList<Extra> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Extra extra = new Extra();
                extra.setId(resultSet.getInt(1));
                extra.setName(resultSet.getString(2));
                extra.setImage(resultSet.getString(3));

                arrayList.add(extra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<Extra> getByCategory(int category) {
        System.out.println("Obteniendo todos los extras por categoría");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"EXTRA\" WHERE id IN (SELECT extra FROM \"EXTRACATEGORY\" WHERE category = " + category + ") ORDER BY id ASC");

        ArrayList<Extra> arrayList = new ArrayList<>();

        try {
            while (resultSet.next()) {
                Extra extra = new Extra();
                extra.setId(resultSet.getInt(1));
                extra.setName(resultSet.getString(2));
                extra.setImage(resultSet.getString(3));

                arrayList.add(extra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }

    public ArrayList<Extra> getById(int id) {
        System.out.println("Obteniendo el extra por ID");

        motorSQL.connect();

        ResultSet resultSet = motorSQL.executeQuery("SELECT * FROM public.\"EXTRA\" WHERE id = " + id);

        ArrayList<Extra> arrayList = new ArrayList<>();

        Extra extra = new Extra();

        try {
            while (resultSet.next()) {
                extra = new Extra();
                extra.setId(resultSet.getInt(1));
                extra.setName(resultSet.getString(2));
                extra.setImage(resultSet.getString(3));

                arrayList.add(extra);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return arrayList;
    }
}

