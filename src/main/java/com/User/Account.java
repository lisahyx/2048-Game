package com.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
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
    }

    public static Account printAccount() {
        System.out.print(accounts);
        return null;
    }

    public void addUsername(String username) throws IOException {
        File oldFile = new File("C:\\Users\\lisah\\IdeaProjects\\COMP2042_CW_hfylh2\\highScoreList.txt");
        File newFile = new File("newHighScoreList.txt");

        BufferedReader reader = new BufferedReader(new FileReader("highScoreList.txt"));

        String line = null;
        String nextLine;
        String lastline = null;

        FileWriter file_writer;
        file_writer = new FileWriter(newFile, true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        while ((nextLine = reader.readLine()) != null) {
            line = nextLine;

            if (Objects.equals(username.toUpperCase(), nextLine.substring(0, nextLine.indexOf("\t")))) {
                lastline = nextLine;
            }
            else {
                buffered_Writer.write(line + "\n");
            }
        }
        buffered_Writer.write(lastline);
        buffered_Writer.flush();
        buffered_Writer.close();
        file_writer.close();
        reader.close();

        oldFile.delete();
        newFile.renameTo(oldFile);
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
