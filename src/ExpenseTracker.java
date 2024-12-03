import api.Commands;
import api.HelpCommand;
import common.FileControl;
import common.Record;
import core.CommandRegistry;

import java.util.ArrayList;

public class ExpenseTracker {


    public static void main(String[] args) {
        Commands commands;
        ArrayList<Record> recordsArrayList = new ArrayList<>();
        FileControl fileControl = new FileControl();
        fileControl.read(recordsArrayList);
        CommandRegistry registry = new CommandRegistry();

        if (args.length == 0) {
            System.out.println("Usage: java ExpenseTracker <command-type>");
            new HelpCommand().execute(args, recordsArrayList);
        } else {
            registry.executeCommand(args[0], args, recordsArrayList);
        }
        fileControl.write(recordsArrayList);

    }
}