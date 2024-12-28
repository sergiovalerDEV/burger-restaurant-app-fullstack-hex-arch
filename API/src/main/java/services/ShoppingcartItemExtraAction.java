package services;

import model.dao.ShoppingcartItemExtraDAO;
import model.entities.ShoppingcartItemExtra;
import model.motorsql.FactoryMotorSQL;
import model.motorsql.MotorSQL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ShoppingcartItemExtraAction implements InterfaceAction {

    final String originalPath = "/shoppingcartitemextra";

    final String getAllPath = originalPath + "/getall";
    final String getByShoppingcartItemPath = originalPath + "/getbyshoppingcartitem";
    final String addPath = originalPath + "/add";
    final String updatePath = originalPath + "/update";

    @Override
    public String callNecesaryMethod(HttpServletRequest request, HttpServletResponse response) {

        String path = request.getPathInfo();

        int shoppingcartItem;
        int extra;

        switch (path) {
            case getAllPath:
                return getAll();
            case getByShoppingcartItemPath:
                shoppingcartItem = Integer.parseInt(request.getParameter("SHOPPINGCARTITEM"));
                return getByShoppingcartItem(shoppingcartItem);
            case addPath:
                shoppingcartItem = Integer.parseInt(request.getParameter("SHOPPINGCARTITEM"));
                extra = Integer.parseInt(request.getParameter("EXTRA"));
                int ammount = Integer.parseInt(request.getParameter("AMMOUNT"));
                ShoppingcartItemExtra shoppingcartItemExtra = new ShoppingcartItemExtra(extra, ammount, shoppingcartItem);
                add(shoppingcartItemExtra);
                return "";
            case updatePath:
                shoppingcartItem = Integer.parseInt(request.getParameter("SHOPPINGCARTITEM"));
                extra = Integer.parseInt(request.getParameter("EXTRA"));
                ammount = Integer.parseInt(request.getParameter("AMMOUNT"));
                shoppingcartItemExtra = new ShoppingcartItemExtra(extra, ammount, shoppingcartItem);
                update(shoppingcartItemExtra);
                return "";
            default:
                System.out.println("The method trying to access does not exist");
                return "";
        }
    }

    public String getAll() {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemExtraDAO shoppingcartItemExtraDAO = new ShoppingcartItemExtraDAO(motorSQL);
        ArrayList<ShoppingcartItemExtra> arrayList = shoppingcartItemExtraDAO.getAll();

        return ShoppingcartItemExtra.toJSON(arrayList);
    }

    public String getByShoppingcartItem(int shoppingcartItem) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemExtraDAO shoppingcartItemExtraDAO = new ShoppingcartItemExtraDAO(motorSQL);
        ArrayList<ShoppingcartItemExtra> arrayList = shoppingcartItemExtraDAO.getByShoppingcartItem(shoppingcartItem);

        return ShoppingcartItemExtra.toJSON(arrayList);
    }

    void add(ShoppingcartItemExtra shoppingcartItemExtra) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemExtraDAO shoppingcartItemExtraDAO = new ShoppingcartItemExtraDAO(motorSQL);
        shoppingcartItemExtraDAO.add(shoppingcartItemExtra);
    }

    void update(ShoppingcartItemExtra shoppingcartItemExtra) {
        MotorSQL motorSQL = FactoryMotorSQL.getInstance("MOTORPOSTGRE");
        ShoppingcartItemExtraDAO shoppingcartItemExtraDAO = new ShoppingcartItemExtraDAO(motorSQL);
        shoppingcartItemExtraDAO.update(shoppingcartItemExtra);
    }
}
