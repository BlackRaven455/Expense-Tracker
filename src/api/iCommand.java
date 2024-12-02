package api;

import common.Record;

import java.util.ArrayList;

public interface iCommand {
    public void execute(String[] args, ArrayList<Record> records);

}
