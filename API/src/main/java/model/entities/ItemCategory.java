package model.entities;

public class ItemCategory {
    int category;
    int item;

    public ItemCategory(int category, int item) {
        this.category = category;
        this.item = item;
    }
    public ItemCategory(){

    }

    public int getCategory() {
        return category;
    }

    public int getItem() {
        return item;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setItem(int item) {
        this.item = item;
    }
}
