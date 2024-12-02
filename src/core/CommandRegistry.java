package core;

import api.AddCommand;
import api.Commands;
import api.HelpCommand;
import api.iCommand;
import common.Record;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class CommandRegistry {
    private final Map<String, iCommand> commands = new HashMap<>();

    public CommandRegistry() {
        commands.put(Commands.ADD.getCommandName(), new AddCommand());
//        commands.put("delete", new DeleteCommand());
//        commands.put("list", new ListCommand());
//        commands.put("summary", new SummaryCommand());
        commands.put("help", new HelpCommand());
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
