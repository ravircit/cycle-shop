package com.social.commands;

import com.social.exceptions.InvalidCommandException;
import com.social.model.Command;
import com.social.output.OutputPrinter;
import com.social.CycleService;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutorFactory {
    private Map<String, CommandExecutor> commands = new HashMap<>();

    public CommandExecutorFactory(final CycleService cycleService, OutputPrinter printer) {
        commands.put(ShowPartsCommandExecutor.COMMAND_NAME, new ShowPartsCommandExecutor(cycleService, printer));
        commands.put(CheckPriceCommandExecutor.COMMAND_NAME, new CheckPriceCommandExecutor(cycleService, printer));
        commands.put(ModifyPriceCommandExecutor.COMMAND_NAME, new ModifyPriceCommandExecutor(cycleService, printer));
        commands.put(ExitCommandExecutor.COMMAND_NAME, new ExitCommandExecutor(cycleService, printer));
        commands.put(PurchaseCycleCommandExecutor.COMMAND_NAME, new PurchaseCycleCommandExecutor(cycleService, printer));
    }

    public CommandExecutor getCommandExecutor(final Command command) {
        final CommandExecutor commandExecutor = commands.get(command.getCommandName());
        if (commandExecutor == null) {
            throw new InvalidCommandException();
        }
        return commandExecutor;
    }
}
