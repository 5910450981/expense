package csku.spender;

public class Spender {

    private String record;
    private int income;
    private int expense;

    public Spender(String record, int amount) {
        this.record = record;
        if (amount >= 0){
            this.income = amount;
            this.expense = 0;
        } else {
            this.income = 0;
            this.expense = amount;
        }
    }

    public String getRecord() {
        return record;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

}
