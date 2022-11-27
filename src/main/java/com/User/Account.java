package com.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Account implements Comparable<Account> {
    private long score = 0;
    private String userName;
    private static ArrayList<Account> accounts = new ArrayList<>();

    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    public void addToScore(long score) {
        this.score += score;
    }

    private long getScore() {
        return score;
    }

    private String getUserName() {
        return userName;
    }

    public static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;
    }

    public static void makeNewAccount(String userName){
        Account account = new Account();
        accounts.add(account);
        //return account;
    }

    public static Account printAccount() {
        System.out.print(accounts);
        return null;
    }

    public void addUsername (String username){
        FileWriter file_writer;
        try {
            file_writer = new FileWriter("highScoreList.txt", true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

            buffered_Writer.write(username.toUpperCase() + "\t");
            buffered_Writer.flush();
            buffered_Writer.close();
        } catch (IOException e) {
            System.out.println("Fail to save username" + e);
        }
    }

    public void findDuplicate() throws IOException {
        String allContent = new String(Files.readAllBytes(Paths.get("highScoreList.txt")));

        BufferedReader reader = new BufferedReader(new FileReader("highScoreList.txt"));
        String line = null;
        String nextLine;

        while ((nextLine = reader.readLine()) != null) {
            line = nextLine;
            System.out.print(line + "\n");
            if ((userName).equals(line)) {
                System.out.print("NOT UNIQUE");
            }
        }
        String[] names = allContent.split("\t");


        /*
        //allContent.split("\t"); //get username only
        String[] names = allContent.split("\t");
        String str = allContent.split("\t")[0];
        System.out.print(str);
        int i =0;
        for(String s:names)
        {
            System.out.println(s);
            i++;
        }

        if(username.getText() == allContent) {
            System.out.print("NOT UNIQUE");
        }
        */
    }

    // save score to file
    public void addScore(long score){
        Long line = score;

        FileWriter file_writer;
        try {
            file_writer = new FileWriter("highScoreList.txt", true);
            BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
            buffered_Writer.write(line+"\n");
            buffered_Writer.flush();
            buffered_Writer.close();
        } catch (IOException e) {
            System.out.println("Fail to save score" + e);
        }
    }
}
