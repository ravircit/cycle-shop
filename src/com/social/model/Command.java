package com.social.model;

import com.social.exceptions.InvalidCommandException;

import java.util.*;
import java.util.stream.Collectors;

public class Command {

    private static final String SPACE = " ";
    private String commandName;
    private List<String> params;
    private String currentDate;

    public String getCommandName() {
        return commandName;
    }

    public List<String> getParams() {
        return params;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public Command(final String inputLine, String currentDate) {
        final List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE))
                .map(String::trim)
                .filter(token -> (token.length() > 0)).collect(Collectors.toList());

        if (tokensList.size() == 0) {
            throw new InvalidCommandException();
        }
        this.currentDate = currentDate;
        commandName = tokensList.get(0).toLowerCase();
        tokensList.remove(0);
        params = tokensList;
    }
}
