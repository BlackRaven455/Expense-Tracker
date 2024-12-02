package common;

import api.iFileControl;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileControl implements iFileControl {

    private final String FILE_PATH = "src/resources/expenses.txt";
    private File file;
    private Path path = null;

    //    Initialize records list
    public FileControl() {
        try {
            path = Path.of(FILE_PATH);
            file = path.toFile();
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (InvalidPathException e) {
            throw new RuntimeException("Path error: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error creating file: " + e.getMessage());
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
        // Load existing records
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream inputStream = new ObjectInputStream(fis)) {
            while (inputStream.available() > 0) {
                records.add((Record) inputStream.readObject());
            }
        } catch (EOFException e) {
            // Reached the end of the file; no more objects to read
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error reading records: " + e.getMessage());
        }

    }
}
