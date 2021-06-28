package api.controller.model;

import com.google.gson.annotations.SerializedName;

public class ProductPrice {

    @SerializedName("current")
    private Float current;
    @SerializedName("total")
    private Float total;
    @SerializedName("currency")
    private String currency;
    @SerializedName("currencyCode")
    private String currencyCode;

    public Float getCurrent() {
        return current;
    }

    public ProductPrice setCurrent(Float current) {
        this.current = current;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public ProductPrice setTotal(Float total) {
        this.total = total;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public ProductPrice setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public ProductPrice setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }
}