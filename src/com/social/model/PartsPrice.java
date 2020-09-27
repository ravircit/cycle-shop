package com.social.model;

public class PartsPrice {

    private String fromDate;
    private String toDate;
    private double price;

    public PartsPrice(String fromDate, String toDate, double price) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.setPrice(price);
    }

    public PartsPrice() {
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PartsPrice{" +
                "price=" + getPrice() +
                '}';
    }
}

