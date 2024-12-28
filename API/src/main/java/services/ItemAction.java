package services;

import model.dao.ItemDAO;
import model.entities.Item;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ItemAction implements InterfaceAction {
    final String getAllBurguers = "getallburguers";
    final String getAllPath = "getall";
    final String getByCategoryPath = "getbycategory";
    final String getByIdPath = "getbyid";
    //final String addPath = originalPath + "/add";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("ACTION").split("\\.")[1];

        System.out.println("Action 2: " + action);

        switch (action){
            case getAllBurguers:
            return getAllBurguers();
            case getAllPath:
                return getAll();
            case getByCategoryPath:
                int category = Integer.parseInt(request.getParameter("CATEGORY"));
                return getByCategory(category);
            case getByIdPath:
                int id = Integer.parseInt(request.getParameter("ID"));
                return getById(id);
            default:
                return "The method trying to access not exists";
        }
    }

    String getAllBurguers(){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ItemDAO itemDAO = new ItemDAO(motorSQL);
        ArrayList arrayList = itemDAO.getAllBurguers();
        return Item.toJSON(arrayList);
    }

    String getAll(){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        motorSQL.connect();
        ItemDAO itemDAO = new ItemDAO(motorSQL);
        ArrayList arrayList  = itemDAO.getAll();
        motorSQL.disconnect();

        return Item.toJSON(arrayList);
    }

    String getByCategory(int category){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        motorSQL.connect();
        ItemDAO itemDAO = new ItemDAO(motorSQL);
        ArrayList arrayList  = itemDAO.getByCategory(category);
        motorSQL.disconnect();

        return Item.toJSON(arrayList);
    }

    String getById(int id){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        motorSQL.connect();
        ItemDAO itemDAO = new ItemDAO(motorSQL);
        ArrayList arrayList = itemDAO.getById(id);
        motorSQL.disconnect();

        return Item.toJSON(arrayList);
    }
}
