package com.wipro.streams;

public class Product {
    private String prodCat;
    private String prodName;
    private double prodPrice;

    public Product(String prodCat, String prodName, double prodPrice) {
        this.prodCat = prodCat;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public String getProdCat() {
        return prodCat;
    }

    public String getProdName() {
        return prodName;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    @Override
    public String toString() {
        return prodName + " (" + prodCat + ") : " + prodPrice;
    }
}
