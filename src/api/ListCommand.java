package api;

import common.Record;

import java.util.ArrayList;

public class ListCommand implements iCommand{
    @Override
    public void execute(String[] args, ArrayList<Record> records){
        if(records.isEmpty()){
            System.out.println("No records found");
        }
        else{

            for(Record r : records){
                System.out.println(r.toString());
            }
        }

    }
}
