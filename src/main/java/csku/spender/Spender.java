package csku.spender;

public class Spender {

    private String record;
    private String type;
    private double amount;
    private String date;

    public Spender(String record, double amount, String date) {
        this.record = record;
        if (amount >= 0){
            this.type = "Income";
        } else {
            this.type = "Expense";
            amount *= -1;
        }
        this.amount = amount;
        this.date = date;
    }

    public Spender(String record, String type, double amount, String date) {
        this.record = record;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        if (amount >= 0) this.type = "Income";
        else this.type = "Expense";
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRecord() {
        return record;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }



}
