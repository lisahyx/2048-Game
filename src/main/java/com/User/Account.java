package com.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
        oldFile.createNewFile(); // create file if file does not exist
        File newFile = new File("newHighScoreList.txt");

        BufferedReader reader = new BufferedReader(new FileReader(oldFile));

        String nextLine = reader.readLine();
        String lastLine1 = null;
        String lastLine2 = null;

        FileWriter file_writer;
        file_writer = new FileWriter(newFile, true);
        BufferedWriter buffered_Writer = new BufferedWriter(file_writer);

        if (nextLine == null){
            lastLine2 = username.toUpperCase() + " ";
        }
        else {
             while (nextLine != null) {
                if (Objects.equals(username.toUpperCase(), nextLine.substring(0, nextLine.indexOf(" ")))) {
                    lastLine1 = nextLine;
                } else {
                    buffered_Writer.write(nextLine + "\n");
                    lastLine2 = username.toUpperCase() + " ";
                }
                nextLine = reader.readLine();
            }
        }

        if(lastLine1 != null) {
            buffered_Writer.write(lastLine1 + "\n");
        } else if (lastLine2 != null) {
            buffered_Writer.write(lastLine2);
        }

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
