import services.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="Controller", urlPatterns = {"/controller/*"})
public class Controller extends HttpServlet {
    final String USER = "user";
    final String ITEM = "item";
    final String CATEGORY = "category";
    final String ITEMCATEGORY = "itemcategory";
    final String SHOPPINGCART = "shoppingcart";
    final String SHOPPINGCARTITEM = "shoppingcartitem";
    final String SHOPPINGCARTITEMEXTRA = "shoppingcartitemextra";
    final String EXTRA = "extra"; // Nuevo servicio

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/plain;charset=UTF-8");

        String action = request.getParameter("ACTION").split("\\.")[0];

        System.out.println("Action: " + action);

        PrintWriter out = response.getWriter();

        String resp;

        switch (action.toLowerCase()) {
            case USER:
                UserAction userService = new UserAction();
                resp = userService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case ITEM:
                ItemAction itemService = new ItemAction();
                resp = itemService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case CATEGORY:
                CategoryAction categoryService = new CategoryAction();
                resp = categoryService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case ITEMCATEGORY:
                ItemCategoryAction itemCategoryService = new ItemCategoryAction();
                resp = itemCategoryService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case SHOPPINGCART:
                ShoppingcartAction shoppingcartService = new ShoppingcartAction();
                resp = shoppingcartService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case SHOPPINGCARTITEM:
                ShoppingcartItemAction shoppingcartItemService = new ShoppingcartItemAction();
                resp = shoppingcartItemService.callNecesaryMethod(request, response);
                out.println(resp);
                break;
            case SHOPPINGCARTITEMEXTRA:
                ShoppingcartItemExtraAction shoppingcartItemExtraService = new ShoppingcartItemExtraAction(); // Nuevo servicio
                resp = shoppingcartItemExtraService.callNecesaryMethod(request, response); // Nuevo servicio
                out.println(resp); // Nuevo servicio
                break; // Nuevo servicio
            case EXTRA:
                ExtraAction extraService = new ExtraAction(); // Nuevo servicio
                resp = extraService.callNecesaryMethod(request, response); // Nuevo servicio
                out.println(resp); // Nuevo servicio
                break; // Nuevo servicio
            default:
                out.println("The method trying to access does not exist");
        }
    }
}
