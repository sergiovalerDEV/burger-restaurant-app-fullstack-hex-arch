package services;

import model.dao.ShoppingcartItemDAO;
import model.entities.ShoppingcartItem;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShoppingcartItemAction implements InterfaceAction {
    final String getAllPath = "getall";
    final String getByShoppingcartAndItem = "getbyshoppingcartanditem";
    final String getByShoppingcartPath = "getbyshoppingcart";
    final String addPath = "add";
    final String updatePath = "update";
    final String updateOnlyByIngredientsPath = "updateByIngredients";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("ACTION").split("\\.")[1];

        System.out.println("Action 2: " + action);

        int shoppingcart;
        int item;
        String extras;

        switch (action){
            case getAllPath:
                return getAll();
            case getByShoppingcartPath:
                shoppingcart = Integer.parseInt(request.getParameter("SHOPPINGCART"));
                return getByShoppingcart(shoppingcart);
            case getByShoppingcartAndItem:
                shoppingcart = Integer.parseInt(request.getParameter("SHOPPINGCART"));
                item = Integer.parseInt(request.getParameter("ITEM"));
                return getById(shoppingcart, item);
            case addPath:
                shoppingcart = Integer.parseInt(request.getParameter("SHOPPINGCART"));
                item=  Integer.parseInt(request.getParameter("ITEM"));
                //int ammount = Integer.parseInt(request.getParameter("AMMOUNT"));
                ShoppingcartItem shoppingcartItem = new ShoppingcartItem(shoppingcart, item, 1, "");
                add(shoppingcartItem);
                return "";
            case updatePath:
                shoppingcart = Integer.parseInt(request.getParameter("SHOPPINGCART"));
                item = Integer.parseInt(request.getParameter("ITEM"));
                int ammount = Integer.parseInt(request.getParameter("AMMOUNT"));
                extras = request.getParameter("EXTRAS");
                shoppingcartItem = new ShoppingcartItem(shoppingcart, item, ammount, extras);
                update(shoppingcartItem);
                return "";
            case updateOnlyByIngredientsPath:
                shoppingcart = Integer.parseInt(request.getParameter("SHOPPINGCART"));
                item = Integer.parseInt(request.getParameter("ITEM"));
                extras = request.getParameter("EXTRAS");
                shoppingcartItem = new ShoppingcartItem(shoppingcart, item, extras);
                updateOnlyIngredients(shoppingcartItem);
                return "";
            default:
                System.out.println("The method trying to access not exists");
                return "";
        }
    }

    public String getAll(){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        ArrayList arrayList = shoppingcartItemDAO.getAll();

        return ShoppingcartItem.toJSON(arrayList);
    }

    public String getByShoppingcart(int shoppingcart) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        ArrayList arrayList = shoppingcartItemDAO.getByShoppingcart(shoppingcart);

        return  ShoppingcartItem.toJSON(arrayList);
    }

    String getById(int shoppingcart, int item){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        ArrayList arrayList = shoppingcartItemDAO.getById(shoppingcart, item);
        return ShoppingcartItem.toJSON(arrayList);
    }

    void add(ShoppingcartItem shoppingcartItem) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        shoppingcartItemDAO.add(shoppingcartItem);
    }

    void update(ShoppingcartItem shoppingcartItem){
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        shoppingcartItemDAO.update(shoppingcartItem);
    }

    void updateOnlyIngredients(ShoppingcartItem shoppingcartItem) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemDAO shoppingcartItemDAO = new ShoppingcartItemDAO(motorSQL);
        shoppingcartItemDAO.updateOnlyIngredients(shoppingcartItem);
    }
}
