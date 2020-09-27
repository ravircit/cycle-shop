package com.social.commands;

import com.social.model.Command;
import com.social.output.OutputPrinter;
import com.social.CycleService;

public abstract class CommandExecutor {
    CycleService cycleService;
    OutputPrinter outputPrinter;
    public CommandExecutor(CycleService cycleService, OutputPrinter outputPrinter) {
        this.cycleService=cycleService;
        this.outputPrinter =outputPrinter;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);
}
