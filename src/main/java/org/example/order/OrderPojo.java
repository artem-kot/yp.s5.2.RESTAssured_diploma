package org.example.order;

public class OrderPojo {
    private String[] ingredients;

    public OrderPojo(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public OrderPojo() {
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}
