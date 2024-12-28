package services;

import model.dao.CategoryDAO;
import model.entities.Category;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class CategoryAction implements InterfaceAction {
    final String getAllPath = "getall";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("ACTION").split("\\.")[1];

        System.out.println("Action 2: " + action);

        switch (action){
            case getAllPath:
                return getAll();
            default:
                return "The method trying to access not exists";
        }
    }

    public String getAll(){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        CategoryDAO categoryDAO = new CategoryDAO(motorSQL);
        ArrayList arrayList = categoryDAO.getAll();

        return Category.toJSON(arrayList);
    }
}
