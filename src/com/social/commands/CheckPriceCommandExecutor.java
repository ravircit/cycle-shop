package com.social.commands;

import com.social.model.Command;
import com.social.model.Cycle;
import com.social.output.OutputPrinter;
import com.social.CycleService;

public class CheckPriceCommandExecutor extends CommandExecutor
{
    public static String COMMAND_NAME = "check_cycle_price";

    public CheckPriceCommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
        super(cycleService,outputPrinter);
    }

    @Override
    public boolean validate(Command command) {
        if (command.getCommandName().equals(COMMAND_NAME) && command.getParams().size()==1)
            return true;
        return false;
    }

    @Override
    public void execute(Command command) {
        Cycle cycle = cycleService.getPurchasedCycleForCustomer(cycleService.getCurrentCustomer());
        outputPrinter.showPurchasedList(cycle.getComponents(), command.getCurrentDate(),cycleService.getCurrentCustomer());
    }
}
