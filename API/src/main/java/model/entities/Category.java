package model.entities;

import java.util.ArrayList;

public class Category {
    int id;
    String name;
    String img;

    public Category(int id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public Category(){

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static String toJSON(ArrayList<Category> arrayList){
        String json = "[";

        for (Category a: arrayList){
            if(json.charAt(json.length() - 1) == '}'){
                json += ",\n";
            }
            json += "{\"id\": \"" + a.getId() + "\",\n" +
                    "\"name\": \"" + a.getName() + "\",\n" +
                    "\"img\": \"" + a.img + "\"\n" +
                    "}";
            }
        json += "]";
        return json;
    }
}
