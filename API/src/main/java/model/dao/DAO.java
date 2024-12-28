package model.dao;

import java.util.ArrayList;

public interface DAO <Object>{
    void update(Object object);
    void add(Object object);
    void remove();
    ArrayList<Object> getAll();
}
