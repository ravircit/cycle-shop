package com.social.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cycle {
    List<Component> components = new ArrayList<>();

    public Cycle() {
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public Cycle(List<Component> components) {
        this.components = components;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Map<String, List<CyclePart>> getComponentMap() {
        Map<String, List<CyclePart>> allComponents = new HashMap<>();
        for (Component component : this.components) {
            allComponents.put(component.getComponentName(), component.getParts());
        }
        return allComponents;
    }
}

