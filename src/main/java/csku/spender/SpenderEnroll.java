package csku.spender;

import java.util.ArrayList;

public class SpenderEnroll {

    private int balance;
    private ArrayList<Spender> spenders = new ArrayList<>();

    public SpenderEnroll(int amount) {
        this.balance = amount;
    }

    public SpenderEnroll() {
        this.balance = 0;
    }

    public void add(int amount){
        spenders.add(new Spender(amount));
        this.balance += amount;
    }

    public String getEnroll(){
        String tmp = "\n";
        for (int i = 0; i < spenders.size(); i++){
            tmp += "Income : " + spenders.get(i).getIncome() +
                    " expense.features : " + spenders.get(i).getExpense() + "\n";
        }
        tmp += "Balance : " + this.balance;
        return tmp;
    }

    public int getBalance() {
        return balance;
    }
}
