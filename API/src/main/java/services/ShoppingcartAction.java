package services;

import model.dao.ShoppingcartDAO;
import model.entities.Shoppingcart;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingcartAction implements InterfaceAction {
    final String getOpenedByUserPath = "getopenedbyuser";
    final String getClosedByUserPath = "getclosedbyuser";
    final String updatePath = "update";
    final String addPath = "add";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("ACTION").split("\\.")[1];

        System.out.println("Action 2: " + action);

        int user;
        Shoppingcart shoppingcart;

        switch (action){
            case getOpenedByUserPath:
                user = Integer.parseInt(request.getParameter("USER"));
                return getOpenedByUser(user);
            case getClosedByUserPath:
                user = Integer.parseInt(request.getParameter("USER"));
                return getClosedByUser(user);
            case updatePath:
                //int id = Integer.parseInt(request.getParameter("ID"));
                //user = Integer.parseInt(request.getParameter("USER"));
                //String date = request.getParameter("DATE");
                int id = Integer.parseInt(request.getParameter("ID"));
                String price = (request.getParameter("PRICE"));
                String opened = (request.getParameter("OPENED"));
                shoppingcart = new Shoppingcart();
                shoppingcart.setId(id);
                shoppingcart.setPrice(price);
                shoppingcart.setOpened(opened);
                update(shoppingcart);
                return  "";
            case addPath:
                user = Integer.parseInt(request.getParameter("USER"));
                shoppingcart = new Shoppingcart(0, user, "0", "CURRENT_DATE", "true");
                add(shoppingcart);
                return "";
            default:
                return "";
        }
    }

    String getOpenedByUser (int user){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO(motorSQL);
        ArrayList arrayList = shoppingcartDAO.getOpenedByUser(user);

        return Shoppingcart.toJSON(arrayList);
    }

    String getClosedByUser (int user){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO(motorSQL);
        ArrayList arrayList = shoppingcartDAO.getClosedByUser(user);

        return Shoppingcart.toJSON(arrayList);
    }

    void update(Shoppingcart shoppingcart){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO(motorSQL);
        shoppingcartDAO.update(shoppingcart);
    }

    void add(Shoppingcart shoppingcart){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartDAO shoppingcartDAO = new ShoppingcartDAO(motorSQL);
        shoppingcartDAO.add(shoppingcart);
    }

    String toJSON(ResultSet resultSet){
        String json = "[\n";

        try{
            while(resultSet.next()){
                if(json.charAt(json.length() - 1) == '}'){
                    json += ",\n";
                }
                json +=
                        "{\n" +
                                "\"id\": \"" + resultSet.getString(1) + "\",\n" +
                                "\"user\": \"" + resultSet.getString(2) + "\",\n" +
                                "\"price\": \"" + resultSet.getString(3) + "\",\n" +
                                "\"date\": \"" + resultSet.getString(4) + "\"\n" +
                                "}\n"
                ;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }

        json += "]";

        return json;
    }
}
