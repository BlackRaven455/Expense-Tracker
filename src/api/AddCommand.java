package api;

import common.Record;

import java.util.ArrayList;

public class AddCommand implements iCommand {

    @Override
    public void execute(String[] args, ArrayList<Record> records) {
        if (args.length < 4) {
            System.out.println("Usage: add --description \"description\" --amount amount");
            return;
        }
        try {
            String description = args[2];
            double amount = Double.parseDouble(args[4]);
//            Record record;
//            if(records.isEmpty()){
//                record = new Record(description,amount, 1);
//            } else {
//                record = new Record(description, amount,records.size());
//            }

            records.add(new Record(description, amount, records.size()));
            System.out.println("Expense added successfully (ID: " + records.getLast().getId() + ")");
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount: " + args[4]);
        }
    }
}
