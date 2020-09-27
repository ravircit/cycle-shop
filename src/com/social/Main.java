package com.social;


import com.social.commands.CommandExecutorFactory;
import com.social.data.CycleStore;
import com.social.output.OutputPrinter;
import com.social.mode.CommandMode;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final CycleService cycleService = new CycleService(args[0]);
        final OutputPrinter printer = new OutputPrinter();
        printer.welcome();
        final CommandExecutorFactory executorFactory = new CommandExecutorFactory(cycleService, printer);
        final CommandMode commandMode = new CommandMode(executorFactory);
        commandMode.process();
    }
}
