package model.entities;

import java.util.ArrayList;

public class User {
    int id;
    String name;
    String address;
    String password;

    public User(int id, String name, String address, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.password = password;
    }

    public User(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String toJSON(ArrayList<User> arrayList){
        String json = "[\n";

        for (User a: arrayList) {
            if(json.charAt(json.length() - 1) == '}'){
                json += ",\n";
            }
            json +=
                    "{\n" +
                            "\"id\": \"" + a.getId() + "\",\n" +
                            "\"name\": \"" + a.getName() + "\",\n" +
                            "\"address\": \"" + a.getAddress() + "\",\n" +
                            "\"password\": \"" + a.getPassword() + "\"\n" +
                            "}";
        }

        json += "]";

        return json;
    }
}
