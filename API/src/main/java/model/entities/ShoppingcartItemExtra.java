package model.entities;

import java.util.ArrayList;

public class ShoppingcartItemExtra {
    int extra;
    int ammount;
    int shoppingcartItem;

    public ShoppingcartItemExtra(int extra, int ammount, int shoppingcartItem) {
        this.extra = extra;
        this.ammount = ammount;
        this.shoppingcartItem = shoppingcartItem;
    }

    public ShoppingcartItemExtra(){

    }

    public int getExtra() {
        return extra;
    }

    public int getAmmount() {
        return ammount;
    }

    public int getShoppingcartItem() {
        return shoppingcartItem;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public void setShoppingcartItem(int shoppingcartItem) {
        this.shoppingcartItem = shoppingcartItem;
    }

    public static String toJSON(ArrayList<ShoppingcartItemExtra> arrayList) {
        String json = "[";
        for (ShoppingcartItemExtra a : arrayList) {
            if (json.charAt(json.length() - 1) == '}') {
                json += ",\n";
            }
            json += "{\"extra\": \"" + a.getExtra() + "\",\n" +
                    "\"ammount\": \"" + a.getAmmount() + "\",\n" +
                    "\"shoppingcartItem\": \"" + a.getShoppingcartItem() + "\"\n" +
                    "}";
        }
        json += "]";
        return json;
    }

}
