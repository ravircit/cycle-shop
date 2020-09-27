package com.social.commands;

import com.social.model.Command;
import com.social.model.Component;
import com.social.output.OutputPrinter;
import com.social.CycleService;

import java.util.List;

public class ShowPartsCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "show_cycle_parts";

    public ShowPartsCommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
        super(cycleService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        if (command.getCommandName().equals(COMMAND_NAME) && command.getParams().size()==0)
            return true;
        return false;
    }

    @Override
    public void execute(Command command) {
        List<Component> components = cycleService.getAllComponents();
        outputPrinter.showParts(components, command.getCurrentDate());
    }
}
