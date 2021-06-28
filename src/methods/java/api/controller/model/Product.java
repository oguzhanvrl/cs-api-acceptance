package api.controller.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product {
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private ProductPrice price;
    @SerializedName("installment")
    private Boolean installment;
    @SerializedName("installmentText")
    private String installmentText;
    @SerializedName("productGroupId")
    private Integer productGroupId;
    @SerializedName("variantCode")
    private String variantCode;
    @SerializedName("deliveryChargeMessage")
    private String deliveryChargeMessage;

    public String getCode() {
        return code;
    }

    public Product setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public ProductPrice getPrice() {
        return price;
    }

    public Product setPrice(ProductPrice price) {
        this.price = price;
        return this;
    }

    public Boolean getInstallment() {
        return installment;
    }

    public Product setInstallment(Boolean installment) {
        this.installment = installment;
        return this;
    }

    public String getInstallmentText() {
        return installmentText;
    }

    public Product setInstallmentText(String installmentText) {
        this.installmentText = installmentText;
        return this;
    }

    public Integer getProductGroupId() {
        return productGroupId;
    }

    public Product setProductGroupId(Integer productGroupId) {
        this.productGroupId = productGroupId;
        return this;
    }

    public String getVariantCode() {
        return variantCode;
    }

    public Product setVariantCode(String variantCode) {
        this.variantCode = variantCode;
        return this;
    }

    public String getDeliveryChargeMessage() {
        return deliveryChargeMessage;
    }

    public Product setDeliveryChargeMessage(String deliveryChargeMessage) {
        this.deliveryChargeMessage = deliveryChargeMessage;
        return this;
    }
}
