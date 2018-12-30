package csku.model;

import csku.data.SpenderEnroll;
import csku.database.SpenderEnrollDB;
import csku.spender.Spender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SpenderModel {

    SpenderEnroll spender = new SpenderEnroll();
    SpenderEnrollDB spenderDB = new SpenderEnrollDB();
    private ArrayList<Spender> spenders;
    private double balance;

    public double getBalance(){
        spenders = spender.getSpenders();
        double sum = 0;
        for (Spender s : spenders) {
            if (s.getType().equals("Income")) sum += s.getAmount();
            else sum -= s.getAmount();
        }
        this.balance = sum;
        return this.balance;
    }

    public void addSpender(String record, double amount, String date){
        spender.writeFile(format(new Spender(record, amount, date)));
    }

    public void addToDB(String record, double amount, String date){
        String[] spender = format(new Spender(record, amount, date)).split(",");
        String rec = spender[0];
        String typ = spender[1];
        String amo = spender[2];
        String dat = spender[3];
        spenderDB.add(rec, typ, amo, dat);
    }

    public void editSpender(Spender current, String record, double amount, String date){
        Spender replace = null;
        for (Spender s : spenders) {
            if (s.equals(current)){
                s.setRecord(record);
                s.setAmount(amount);
                s.setDate(date);
                replace = s;
            }
        }
        spender.edit(format(current), format(replace));
    }

    public void remove(Spender current){
        spender.edit(format(current), "");
    }

    public ObservableList show(){
        spenders = spender.getSpenders();
        ObservableList spender = FXCollections.observableArrayList();
        for (Spender s : spenders) {
            spender.add(s);
        }
        return spender;
    }

    public ArrayList getSpender(){
        spenders = spender.getSpenders();
        return this.spenders;
    }

    private String format(Spender spender){
        return spender.getRecord() + "," + spender.getType() + "," +  spender.getAmount()
                + "," +  spender.getDate();
    }

}
