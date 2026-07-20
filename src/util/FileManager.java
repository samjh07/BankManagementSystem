package util;

import model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts(List<Account> accounts) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Account acc : accounts) {

                bw.write(
                        acc.getAccountNumber() + "," +
                        acc.getHolderName() + "," +
                        acc.getAccountType() + "," +
                        acc.getMobile() + "," +
                        acc.getEmail() + "," +
                        acc.getBalance()
                );

                bw.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error while saving accounts.");
        }
    }

    public static List<Account> loadAccounts() {

        List<Account> accounts = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return accounts;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                Account account = new Account(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Double.parseDouble(data[5])
                );

                accounts.add(account);
            }

        } catch (Exception e) {

            System.out.println("Error while loading accounts.");
        }

        return accounts;
    }
}