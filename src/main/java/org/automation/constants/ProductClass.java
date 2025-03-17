package org.automation.constants;

public enum ProductClass {

    FIRST_PRODUCT("Puma Hoodie"),
    SECOND_PRODUCT("Atalanta Joma"),
    THIRD_PRODUCT("Real Madrid Adidas"),
    FOURTH_PRODUCT("Germany Shirt");

    private final String product;

    ProductClass(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}