package org.automation.constants;

public enum ProductClass {

    FIRST_PRODUCT("AC Milan"),
    SECOND_PRODUCT("Socks"),
    THIRD_PRODUCT("Jacket"),
    FOURTH_PRODUCT("Shirt"),
    FIFTH_PRODUCT("Jacket");

    private final String product;

    ProductClass(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
}