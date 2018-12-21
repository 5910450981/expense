package csku.database;

import csku.spender.Spender;

import java.sql.*;
import java.util.ArrayList;

public class SpenderEnrollDB {

    private ArrayList<Spender> spenders = new ArrayList<>();

//    public void edit(String spender, String replace){
//        String[] spenders = spender.split(",");
//        String[] replaces = replace.split(",");
//        try {
//            //setup
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:SpenderDB.db";
//            Connection conn = DriverManager.getConnection(dbURL);
//            if (conn != null) {
//                //execute SQL statements
//                String query = "UPDATE SpenderEnroll set record = ";
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//                while (resultSet.next()) {
//                    String record = resultSet.getString(1);
//                    double amount = resultSet.getDouble(3);
//                    String date = resultSet.getString(4);
//                    spenders.add(new Spender(record, amount, date));
//                }
//                //close connection
//                conn.close();
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

    private void read() {
        try {
            //setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:SpenderDB.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                //execute SQL statements
                String query = "Select * from SpenderEnroll";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String record = resultSet.getString(1);
                    double amount = resultSet.getDouble(3);
                    String date = resultSet.getString(4);
                    spenders.add(new Spender(record, amount, date));
                }
                //close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Spender> getSpender(){
        read();
        return this.spenders;
    }


}
