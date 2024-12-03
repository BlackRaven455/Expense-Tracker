package common;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Record implements Serializable {

    //    private static int idCounter = 1;
    private int id;
    private String description;
    private double amount;
    private LocalDateTime date;

    public Record(String description, double amount, int id) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.date = LocalDateTime.parse(date);
    }


    public String getDescription() {
        return description;
    }

    public double getAmount() {

        return amount;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty.");
        }
        this.description = description;
    }


    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "ID: " + id + ", Date: " + date.format(formatter) +
                ", Description: " + description + ", Amount: $" + amount;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
}
