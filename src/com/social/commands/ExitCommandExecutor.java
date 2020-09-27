package com.social.commands;

import com.social.model.Command;
import com.social.output.OutputPrinter;
import com.social.CycleService;

public class ExitCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "exit";

    public ExitCommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
        super(cycleService, outputPrinter);
    }

    @Override
    public boolean validate(final Command command) {
        return command.getParams().isEmpty();
    }


    @Override
    public void execute(final Command command) {

    }
}
