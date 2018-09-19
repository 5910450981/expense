package csku.spender;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SpenderEnroll {

    private int balance;

    private ArrayList<Spender> spenders = new ArrayList<>();
    private static final String FILENAME = "SpenderEnroll.txt";

    public SpenderEnroll(int amount) {
        this.balance = amount;
    }

    public SpenderEnroll() {
        this.balance = 0;
    }

    public void add(String record,int amount){
        spenders.add(new Spender(record ,amount));
        this.balance += amount;
    }

    public String getEnroll(){
        String tmp = "\n";
        for (int i = 0; i < spenders.size(); i++){
            tmp += "Record : " + spenders.get(i).getRecord() +
                    " Income : " + spenders.get(i).getIncome() +
                    " Expense : " + spenders.get(i).getExpense() + "\n";
        }
        tmp += "Balance : " + this.balance;
        return tmp;
    }

    public int getBalance() {
        return balance;
    }

    public void run() {

        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        Date date = new Date();

        try {
            Scanner scan = new Scanner(System.in);

            FileWriter fileSteam = new FileWriter(FILENAME, true);
            BufferedWriter writer = new BufferedWriter(fileSteam);
            String record;
            String function;
            int price;

            while (true){
                System.out.print("Choose Your Function Add[A]/Exit[E] : ");
                function = scan.next();
                function.toLowerCase();
                if (function.equals("a")){
                    System.out.print("Enter Your Spender Record [ ex. food ] : ");
                    record = scan.next();
                    System.out.print("Enter Your Price of Record [ ex. 45 ] : ");
                    price = scan.nextInt();
                    add(record, price);
                } else if (function.equals("e")){
                    break;
                } else {
                    System.out.print("Invalid Choice.");
                }
            }

            writer.write(getEnroll());
            writer.newLine();

            writer.write(dateFormat.format(date));

            writer.close();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        SpenderEnroll spender = new SpenderEnroll();

        spender.run();
    }

}
