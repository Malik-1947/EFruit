package com.tarun.efruit.Models;

public class ProductModel {
    String image;
    String p_name, p_qty, p_unit, p_price;

    public ProductModel() {
    }

    public ProductModel(String image, String p_name, String p_qty, String p_unit, String p_price) {
        this.image = image;
        this.p_name = p_name;
        this.p_qty = p_qty;
        this.p_unit = p_unit;
        this.p_price = p_price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_qty() {
        return p_qty;
    }

    public void setP_qty(String p_qty) {
        this.p_qty = p_qty;
    }

    public String getP_unit() {
        return p_unit;
    }

    public void setP_unit(String p_unit) {
        this.p_unit = p_unit;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }
}