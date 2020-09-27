package com.social.mode;

import com.social.commands.CommandExecutorFactory;
import com.social.commands.ExitCommandExecutor;
import com.social.model.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class CommandMode extends Mode {


    public CommandMode(CommandExecutorFactory commandExecutorFactory) {
        super(commandExecutorFactory);
    }

    @Override
    public void process() throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LocalDate today = LocalDate.now();
        String currentDate = today.format(DateTimeFormatter.ofPattern("MM-yyyy"));
        DateFormat f = new SimpleDateFormat("mm-yyyy");
        java.util.Date date = java.sql.Date.valueOf(today);

        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input, currentDate);
            processCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}
