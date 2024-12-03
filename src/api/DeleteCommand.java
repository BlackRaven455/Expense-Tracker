package api;

import common.Record;

import java.util.ArrayList;

public class DeleteCommand implements iCommand{


    @Override
    public void execute(String[] args, ArrayList<Record> records) {
        int id = Integer.parseInt(args[1]);
        records.remove(id);
        for(Record record : records){
            record.setId(records.indexOf(record));
        }
    }
}
