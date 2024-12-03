package api;

import common.Record;

import java.util.ArrayList;

public class HelpCommand  implements iCommand{
    @Override
    public void execute(String[] args, ArrayList<Record> records) {
        System.out.println("Usage: expense-tracker <command> [options]");
        System.out.println("Commands:");
        System.out.println("  add --description \"description\" --amount amount");
        System.out.println("  delete  id");
        System.out.println("  list");
        System.out.println("  summary [month]");
        System.out.println("  help");
    }
}
