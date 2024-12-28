package services;

import model.dao.UserDAO;
import model.entities.User;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UserAction implements InterfaceAction {
    final String getByNamePath = "getbyname";
    final String addPath = "add";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("ACTION").split("\\.")[1];

        System.out.println("Action 2: " + action);

        String name;

        switch (action){
            case getByNamePath:
                name = request.getParameter("NAME");
                return getByName(name);
            case addPath:
                name = request.getParameter("NAME");
                String address = request.getParameter("ADDRESS");
                String password = request.getParameter("PASSWORD");

                User user = new User(0, name, address, password);
                add(user);
                return "";
            default:
                return "The method trying to access not exists";
        }
    }

    String getByName(String name){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        UserDAO userDAO = new UserDAO(motorSQL);
        ArrayList arrayList = userDAO.getByName(name);

        return User.toJSON(arrayList);
    }

    void add(User user){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        UserDAO userDAO = new UserDAO(motorSQL);
        userDAO.add(user);
    }
}
