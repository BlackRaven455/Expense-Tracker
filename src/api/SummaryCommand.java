package api;

import common.Record;

import java.util.ArrayList;

public class SummaryCommand implements iCommand {
    private double sum = 0;

    @Override
    public void execute(String[] args, ArrayList<Record> records) {

        if (args.length == 1) {
            for (Record r : records) {
                sum += r.getAmount();

            }
            System.out.println(sum);
        } else {
            monthSummary(args[1], records);
        }



    }

    public void monthSummary(String data, ArrayList<Record> records) {
        int month = 0;
        try {
            month = Integer.parseInt(data);
            if (month < 1 || month > 12) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid month number." + e.getMessage());
            return;
        }

        for (Record r : records) {
            if (r.getDate().getMonthValue() == month) {
                sum += r.getAmount();
            }
        }
        System.out.println(sum);
    }
}
