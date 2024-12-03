package core;

import api.*;
import common.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, iCommand> commands = new HashMap<>();

    public CommandRegistry() {
        for (Commands cmd : Commands.values()) {
            switch (cmd) {
                case ADD -> commands.put(cmd.getCommandName(), new AddCommand());
                case DELETE -> commands.put(cmd.getCommandName(), new DeleteCommand());
                case LIST -> commands.put(cmd.getCommandName(), new ListCommand());
                case SUMMARY -> commands.put(cmd.getCommandName(), new SummaryCommand());
                case HELP -> commands.put(cmd.getCommandName(), new HelpCommand());
//                case EDIT -> commands.put(cmd.getCommandName(), new EditCommand());
            }
        }
    }

    public void executeCommand(String commandName, String[] args, ArrayList<Record> records) {
        iCommand command = commands.get(commandName.toLowerCase());
        if (command != null) {
            command.execute(args, records);
        } else {
            System.out.println("Unknown command: " + commandName);
            new HelpCommand().execute(args, records);
        }
    }
}
