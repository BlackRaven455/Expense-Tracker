package common;

import api.iFileControl;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileControl implements iFileControl {

    private String FILE_PATH = "src/resources/expenses.txt";
    private File file;
    private Path path = null;
   

    //    Initialize records list
    public FileControl(String filePath) {
        this.FILE_PATH = filePath;
        initializeFile();
    }

    private void initializeFile() {
        try {
            path = Path.of(FILE_PATH);
            file = path.toFile();
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (InvalidPathException | IOException e) {
            throw new RuntimeException("Error initializing file: " + e.getMessage(), e);
        }
    }

    @Override
    public void write(ArrayList<Record> records)  {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(this.file);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(records);

            out.close();
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void read(ArrayList<Record> records) {
        if (file.length() == 0) {
            return; // File is empty, no records to read
        }
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            // Deserialize the entire list of records
            records.addAll((ArrayList<Record>) inputStream.readObject());
        } catch (EOFException e) {
            // Reached end of file, normal behavior for empty or incomplete streams
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error reading records: " + e.getMessage(), e);
        }
    }
}
