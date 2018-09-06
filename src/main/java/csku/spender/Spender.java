package csku.spender;

public class Spender {

    private int income;
    private int expense;

    public Spender(int amount) {
        if (amount >= 0){
            this.income = amount;
            this.expense = 0;
        } else {
            this.income = 0;
            this.expense = amount;
        }
    }


    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }

}
