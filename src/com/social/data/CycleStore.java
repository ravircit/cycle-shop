package com.social.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.social.model.Cycle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CycleStore {
    private static CycleStore cycleStore = null;
    private Cycle cycleData;
    List<Cycle> cycles = new ArrayList<>();
    Integer customerCount = 0;

    public void loadData(String fileName) throws FileNotFoundException {
        Path path = Paths.get(fileName);
        if (Files.notExists(path)) {
            throw new FileNotFoundException("File not found.");
        }
        byte[] jsonData = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonData = Files.readAllBytes(Paths.get(fileName));
            cycleData = objectMapper.readValue(jsonData, Cycle.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cycle getCycleData() {
        return cycleData;
    }

    public void addNewCycle(Cycle newCycle) {
        cycles.add(newCycle);
    }

    public List<Cycle> getCycles() {
        return cycles;
    }

    public Integer getCustomerCount() {
        return customerCount;
    }

    public void increaseCustomerCount() {
        this.customerCount++;
    }
}
