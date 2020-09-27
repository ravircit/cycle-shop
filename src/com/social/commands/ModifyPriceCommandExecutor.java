package com.social.commands;

import com.social.model.Command;
import com.social.output.OutputPrinter;
import com.social.CycleService;

public class ModifyPriceCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "modify_price";

    public ModifyPriceCommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
        super(cycleService, outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        if (command.getCommandName().equals(COMMAND_NAME) && command.getParams().size()>0)
            return true;
        return false;
    }

    @Override
    public void execute(Command command) {
        //outputPrinter.modifyPriceMessage();
        cycleService.modifyPrice(command);
    }
}
