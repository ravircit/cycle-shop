package com.social.output;

import com.social.model.Component;
import com.social.model.CyclePart;

import java.util.List;

public class OutputPrinter {
    public void welcome() {
        System.out.println("Welcome to Cycle shop.");
    }

    public void showParts(List<Component> components, String currentDate) {
        int componentCount = 0, partCount = 1;
        for (Component component : components) {
            System.out.println(++componentCount + "." + component.getComponentName());
            partCount = 1;
            for (CyclePart p : component.getParts()) {
                System.out.println("    " + componentCount + "." + partCount++ + " " + p.getName() + " " + p.getPrice(currentDate));
            }
        }
    }

    public void showPurchasedList(List<Component> components, String currentDate, Integer currentCustomer) {
        double componentPrice = 0, totalPrice = 0;
        System.out.println("Purchased list of customer number " + currentCustomer);
        for (Component component : components) {
            componentPrice = 0;
            for (CyclePart p : component.getParts()) {
                totalPrice += p.getPrice(currentDate);
                componentPrice += p.getPrice(currentDate);
            }
            System.out.println("Price of " + component.getComponentName() + " is - " + componentPrice);
        }
        System.out.println("Total price is - " + totalPrice);
    }

    public void modifyPriceMessage() {
        System.out.println("Details of changed price-to date[mm-yyyy], from date[mm-yyyy], price.");
    }

    public void invalidInput(String message) {
        System.out.println(message);
    }

    public void showCommand()
    {
        System.out.println("1. show_cycle_parts.\n2. purchase_cycle.\n3. modify_price");
    }
}
