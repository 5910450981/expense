package csku.data;

import csku.spender.Spender;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SpenderEnroll {

    private String filename = "SpenderEnroll.txt";
    private ArrayList<Spender> spenders = new ArrayList<>();

    public void writeFile(String spender){
        File file = new File(filename);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            FileReader fileReader = new FileReader(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            BufferedReader reader = new BufferedReader(fileReader);
            if (reader.readLine() != null) writer.newLine();
            writer.write(spender);
            writer.flush();
            writer.close();
            reader.close();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFile();
    }

    private void readFile(){
        File file = new File(filename);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null){
                String[] spender = line.split(",");
                String record = spender[0];
                String type = spender[1];
                double amount = Double.parseDouble(spender[2]);
                String date = spender[3];
                spenders.add(new Spender(record, type, amount, date));
            }
            reader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void edit(String current, String replace){
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                if (line.equals(current)) {
                    line = line.replace(current, replace);
                    current = "";
                }
                lines.add(line);
                if ((lines.get(lines.size()-1)).equals("")){
                    lines.remove(lines.size()-1);
                }
            }
            reader.close();
            fileReader.close();

            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                if (i != (lines.size()-1)) writer.newLine();
            }
            writer.flush();
            writer.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFile();
    }

    public ArrayList<Spender> getSpenders() {
        spenders.clear();
        readFile();
        return spenders;
    }
}
