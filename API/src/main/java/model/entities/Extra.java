package model.entities;

import java.util.ArrayList;

public class Extra {
    int id;
    String name;
    String image;

    public Extra(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public Extra(){

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static String toJSON(ArrayList<Extra> arrayList){
        String json = "[";
        for (Extra a: arrayList){
            if(json.charAt(json.length() - 1) == '}'){
                json += ",\n";
            }
            json += "{\"id\": \"" + a.getId() +"\",\n" +
                    "\"name\": \"" + a.getName() +"\",\n" +
                    "\"image\": \"" + a.getImage() +"\"\n" +
                    "}";
        }
        json += "]";
        return json;
    }
}
