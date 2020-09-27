package com.social.model;

import java.util.List;

public class Component {

    private String componentName;
    private List<CyclePart>parts;

    public double getTotalComponentPrice(String date)
    {
        double totalPrice= this.parts.stream().mapToDouble(x -> x.getPrice(date)).sum();
        return totalPrice;
    }

    public Component(String componentName, List<CyclePart> parts) {
        this.componentName = componentName;
        this.parts = parts;
    }

    public Component() {
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public List<CyclePart> getParts() {
        return parts;
    }

    public void addParts(CyclePart part) {
        this.parts.add(part);
    }
    public void setParts(List<CyclePart> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        for(CyclePart cyclePart:parts) {
            stringBuilder.append(" ," + cyclePart.toString());
        }
        return stringBuilder.toString();
    }
}
