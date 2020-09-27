package com.social.commands;

import com.social.exceptions.InputNotValidException;
import com.social.model.Command;
import com.social.model.Cycle;
import com.social.output.OutputPrinter;
import com.social.CycleService;

public class PurchaseCycleCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "purchase_cycle";

    public PurchaseCycleCommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
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
        try {
            cycleService.purchaseCycle(command);
            Cycle cycle = cycleService.getPurchasedCycleForCustomer(cycleService.getCurrentCustomer());
            outputPrinter.showPurchasedList(cycle.getComponents(), command.getCurrentDate(), cycleService.getCurrentCustomer());
        }
        catch(InputNotValidException exception)
        {
            outputPrinter.invalidInput(exception.getMessage());
        }
    }
}
