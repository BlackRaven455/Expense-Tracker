package api;

import common.Record;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface iFileControl {
    //In case there will be diff ways to record info. For example SQl databases, JSON and etc.
    public void write(ArrayList<Record> records) throws FileNotFoundException;
    public void read(ArrayList<Record> records) throws FileNotFoundException;
}
