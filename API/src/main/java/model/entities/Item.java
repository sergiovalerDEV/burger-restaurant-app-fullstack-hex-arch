package model.entities;

import java.util.ArrayList;

public class Item {
    int id;
    String name;
    String image;
    String ingredients;
    int price;

    public Item(int id, String name, String image, String ingredients, int price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Item(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static String toJSON(ArrayList<Item> arrayList){
        String json = "[";
        for (Item a: arrayList){
            if(json.charAt(json.length() - 1) == '}'){
                json += ",\n";
            }
            json += "{\"id\": \"" + a.getId() +"\",\n" +
                    "\"name\": \"" + a.getName() +"\",\n" +
                    "\"image\": \"" + a.getImage() +"\",\n" +
                    "\"ingredients\": \"" + a.getIngredients() +"\",\n" +
                    "\"price\": \"" + a.getPrice() +"\"\n" +
                    "}";
        }
        json += "]";
        return json;
    }
}
