package com.social;

import com.social.data.CycleStore;
import com.social.exceptions.DataLoadFailedException;
import com.social.exceptions.InputNotValidException;
import com.social.model.*;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class CycleService {
    CycleStore cycleStore=null;
    public CycleService(String fileName) {
        cycleStore = new CycleStore();
        try {
            cycleStore.loadData(fileName);
        } catch (FileNotFoundException e) {
            throw new DataLoadFailedException("File not found.");
        }
    }

    public List<Component> getAllComponents() {
        return cycleStore.getCycleData().getComponents();
    }

    public void purchaseCycle(Command command) {
        try {
            cycleStore.increaseCustomerCount();
            List<Component> purchasedComponents = new ArrayList<>();
            int comId = 0, partId = 0;
            Map<Integer, List<Integer>> listMap = new HashMap<>();
            for (String selection : command.getParams()) {
                List<String> str = Arrays.stream(selection.split("\\."))
                        .map(String::trim)
                        .filter(token -> (token.length() > 0)).collect(Collectors.toList());
                comId = Integer.parseInt(str.get(0));
                partId = Integer.parseInt(str.get(1));
                listMap.computeIfAbsent(comId, x -> new ArrayList<>()).add(partId);
            }
            for (Integer componentId : listMap.keySet()) {
                List<CyclePart> cycleParts = new ArrayList<>();
                for (Integer part : listMap.get(componentId)) {
                    cycleParts.add(getAllComponents().get(componentId - 1).getParts().get(part - 1));
                }
                purchasedComponents.add(new Component(getAllComponents().get(componentId - 1).getComponentName(), cycleParts));
            }
            cycleStore.addNewCycle(new Cycle(purchasedComponents));
        } catch (Exception exception) {
            throw new InputNotValidException("Input not valid.");
        }
    }

    public void modifyPrice(Command command) {
        try {
            int comId = 0, partId = 0;
            String[] str = command.getParams().get(0).split("\\.");
            comId = Integer.parseInt(str[0]);
            partId = Integer.parseInt(str[1]);
            cycleStore.getCycleData().getComponents().get(comId - 1).
                    getParts().get(partId - 1).setPrice(new PartsPrice(command.getParams()
                    .get(1), command.getParams().get(2), Double.parseDouble(command.getParams().get(3))));
        } catch (InputNotValidException exception) {
            throw new InputNotValidException("Input not valid.");
        }
    }

    public Cycle getPurchasedCycleForCustomer(Integer customerNumber) {
        return cycleStore.getCycles().get(customerNumber - 1);
    }

    public Integer getCurrentCustomer() {
        return cycleStore.getCustomerCount();
    }
}
