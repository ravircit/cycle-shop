package com.social.model;

import java.util.List;

public class CyclePart {
    private String name;
    private List<PartsPrice> partsPrices;

    public CyclePart() {
    }

    public CyclePart(String name, List<PartsPrice> partsPrices) {
        this.name = name;
        this.partsPrices = partsPrices;
    }

    public double getPrice(String date) {
        for (PartsPrice partsPrice : partsPrices) {
            if (partsPrice.getFromDate().compareTo(date) <= 0 && partsPrice.getToDate().compareTo(date) >= 0)
                return partsPrice.getPrice();
        }
        int size = this.partsPrices.size();
        return this.partsPrices.get(size - 1).getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PartsPrice> getPartsPrices() {
        return partsPrices;
    }

    public void setPrice(PartsPrice partsPrice) {
        this.partsPrices.add(partsPrice);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
