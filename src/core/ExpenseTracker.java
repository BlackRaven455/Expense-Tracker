package core;

import api.Commands;
import api.HelpCommand;
import common.FileControl;
import common.Record;

import java.util.ArrayList;

public class ExpenseTracker {

    private static void showHelp() {
        System.out.println("Usage: expense-tracker <command> [options]");
        System.out.println("Commands:");
        System.out.println("  add --description \"description\" --amount amount");
        System.out.println("  delete --id id");
        System.out.println("  list");
        System.out.println("  summary [--month month]");
        System.out.println("  help");
    }


    public static void main(String[] args) {
        Commands commands;
        ArrayList<Record> recordsArrayList = new ArrayList<>();
        FileControl fileControl = new FileControl();
        fileControl.read(recordsArrayList);
        CommandRegistry registry = new CommandRegistry();

        if (args.length == 0) {
            System.out.println("Usage: java core.ExpenseTracker <command-type>");
            new HelpCommand().execute(args,recordsArrayList);
        } else {
            registry.executeCommand(args[0], args, recordsArrayList);
            }
//            try{

//            commands = Commands.valueOf(args[0].toUpperCase());
//            switch (commands) {
//                case LIST: for(Record r: recordsArrayList){
//                    System.out.println("Record: " + r.toString());
//                } break;
//                case ADD: recordsArrayList.add(new Record(args[2], Integer.parseInt(args[4])));  break;
//                case HELP: showHelp();break;
//                case DELETE: break;
//                case SUMMARY: break;
//            }
//            } catch (IllegalArgumentException e) {
//                System.out.println("Unknown command: " + args[0]);
//            }
//        }
        fileControl.write(recordsArrayList);

    }
}