package api.controller.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Installment {

    @SerializedName("categoryName")
    private String categoryName;
    @SerializedName("products")
    private List<Product> products = null;

    public String getCategoryName() {
        return categoryName;
    }

    public Installment setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Installment setProducts(List<Product> products) {
        this.products = products;
        return this;
    }
}