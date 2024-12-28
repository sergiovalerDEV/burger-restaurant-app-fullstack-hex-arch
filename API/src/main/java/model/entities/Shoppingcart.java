package model.entities;

import java.util.ArrayList;

public class Shoppingcart {
    int id;
    int user;
    String price; //I SET PRICE TO STRING TO ALLOW UPDATE TO HAVE PRICE = PRICE
    String date;
    String opened; //I SET OPENED TO STRING TO ALLOW UPDATE TO HAVE OPENED = OPENED

    public Shoppingcart(int id, int user, String price, String date, String opened) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.date = date;
        this.opened = opened;
    }

    public Shoppingcart(){

    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public String getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String isOpened() {
        return opened;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public static String toJSON(ArrayList<Shoppingcart> arrayList){
        String json = "[";

        for (Shoppingcart a: arrayList) {
            if(json.charAt(json.length() - 1) == '}'){
                json += ",\n";
            }
            json +=
                    "{\n" +
                            "\"id\": \"" + a.getId() + "\",\n" +
                            "\"user\": \"" + a.getUser() + "\",\n" +
                            "\"price\": \"" + a.getPrice() + "\",\n" +
                            "\"date\": \"" + a.getDate() + "\"\n" +
                            "}"
            ;
        }

        json += "]";

        return json;
    }
}
