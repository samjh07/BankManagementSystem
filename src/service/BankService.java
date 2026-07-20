package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankService {
    
    private List<Account> accounts;

    private int nextAccountNumber = 1001;

    public BankService() {
        accounts = new ArrayList<>();
    }

    // ============================
    // Generate Account Number
    // ============================

    private String generateAccountNumber() {
        return "ACC" + nextAccountNumber++;
    }

    // ============================
    // Create Account
    // ============================

    public Account createAccount(String holderName,
                                 String accountType,
                                 String mobile,
                                 String email,
                                 double initialDeposit) {

        if (holderName == null || holderName.trim().isEmpty()) {
            throw new IllegalArgumentException("Holder name cannot be empty.");
        }

        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Invalid opening balance.");
        }

        String accountNumber = generateAccountNumber();

        Account account = new Account(
                accountNumber,
                holderName,
                accountType,
                mobile,
                email,
                initialDeposit
);

        accounts.add(account);

        return account;
    }

    // ============================
    // Search Account
    // ============================

    public Optional<Account> findAccount(String accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {

                return Optional.of(account);

            }

        }

        return Optional.empty();
    }

    // ============================
    // Total Accounts
    // ============================

    public int getTotalAccounts() {
        return accounts.size();
    }



public class Account {

    private String accountNumber;
    private String holderName;
    private String accountType;
    private String mobile;
    private String email;
    private double balance;

    // Default Constructor
    public Account() {
    }

    // Parameterized Constructor
    public Account(String accountNumber,
                   String holderName,
                   String accountType,
                   String mobile,
                   String email,
                   double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.accountType = accountType;
        this.mobile = mobile;
        this.email = email;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "\nAccount Number : " + accountNumber +
               "\nHolder Name   : " + holderName +
               "\nAccount Type  : " + accountType +
               "\nMobile        : " + mobile +
               "\nEmail         : " + email +
               "\nBalance       : ₹" + balance;
    }

        // ============================
    // Delete Account
    // ============================

    public boolean deleteAccount(String accountNumber) {

        Optional<Account> account = findAccount(accountNumber);

        if (account.isPresent()) {

            accounts.remove(account.get());

            return true;
        }

        return false;
    }

    // ============================
    // Display All Accounts
    // ============================

    public void displayAllAccounts() {

        if (accounts.isEmpty()) {

            System.out.println("\nNo Accounts Found.");

            return;
        }

        System.out.println("\n========== ALL ACCOUNTS ==========\n");

        for (Account account : accounts) {

            System.out.println(account);

            System.out.println("----------------------------------");
        }
    }

    // ============================
    // Search By Holder Name
    // ============================

    public List<Account> searchByHolderName(String holderName) {

        List<Account> result = new ArrayList<>();

        for (Account account : accounts) {

            if (account.getHolderName()
                    .toLowerCase()
                    .contains(holderName.toLowerCase())) {

                result.add(account);
            }
        }

        return result;
    }

    // ============================
    // Display Search Result
    // ============================

    public void displaySearchResult(String holderName) {

        List<Account> result = searchByHolderName(holderName);

        if (result.isEmpty()) {

            System.out.println("\nNo Account Found.");

            return;
        }

        System.out.println("\n===== SEARCH RESULT =====\n");

        for (Account account : result) {

            System.out.println(account);

            System.out.println("-----------------------------");
        }
    }

    // ============================
    // Get All Accounts
    // ============================

    public List<Account> getAllAccounts() {

        return accounts;
    }

    // ============================
    // Total Balance In Bank
    // ============================

    public double getTotalBankBalance() {

        double total = 0;

        for (Account account : accounts) {

            total += account.getBalance();
        }

        return total;
    }

    // ============================
    // Total Accounts
    // ============================

    public int totalAccounts() {

        return accounts.size();
    }

        // ============================
    // Transfer Money
    // ============================

    public boolean transferMoney(String senderAccount,
                                 String receiverAccount,
                                 double amount) {

        if (senderAccount.equalsIgnoreCase(receiverAccount)) {
            throw new IllegalArgumentException("Cannot transfer to same account.");
        }

        Optional<Account> sender = findAccount(senderAccount);
        Optional<Account> receiver = findAccount(receiverAccount);

        if (sender.isEmpty() || receiver.isEmpty()) {
            return false;
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid transfer amount.");
        }

        if (sender.get().getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient Balance.");
        }

        sender.get().setBalance(sender.get().getBalance() - amount);

        receiver.get().setBalance(receiver.get().getBalance() + amount);

        return true;
    }

    // ============================
    // Update Account
    // ============================

    public boolean updateAccount(String accountNumber,
                                 String holderName,
                                 String accountType,
                                 String mobile,
                                 String email) {

        Optional<Account> account = findAccount(accountNumber);

        if (account.isEmpty()) {
            return false;
        }

        Account acc = account.get();

        acc.setHolderName(holderName);
        acc.setAccountType(accountType);
        acc.setMobile(mobile);
        acc.setEmail(email);

        return true;
    }

    // ============================
    // Account Exists
    // ============================

    public boolean accountExists(String accountNumber) {

        return findAccount(accountNumber).isPresent();
    }

        // ============================
    // Highest Balance
    // ============================

    public Account getHighestBalanceAccount() {

        if (accounts.isEmpty()) {
            return null;
        }

        Account highest = accounts.get(0);

        for (Account account : accounts) {

            if (account.getBalance() > highest.getBalance()) {

                highest = account;
            }
        }

        return highest;
    }

    // ============================
    // Lowest Balance
    // ============================

    public Account getLowestBalanceAccount() {

        if (accounts.isEmpty()) {
            return null;
        }

        Account lowest = accounts.get(0);

        for (Account account : accounts) {

            if (account.getBalance() < lowest.getBalance()) {

                lowest = account;
            }
        }

        return lowest;
    }

    // ============================
    // Remove All Accounts
    // ============================

    public void clearAllAccounts() {

        accounts.clear();
    }

    // ============================
    // Print Bank Summary
    // ============================

    public void printSummary() {

        System.out.println("\n========== BANK SUMMARY ==========");
        System.out.println("Total Accounts : " + totalAccounts());
        System.out.println("Total Balance  : ₹" + getTotalBankBalance());

        Account highest = getHighestBalanceAccount();
        Account lowest = getLowestBalanceAccount();

        if (highest != null) {
            System.out.println("Highest Balance Account : "
                    + highest.getAccountNumber());
        }

        if (lowest != null) {
            System.out.println("Lowest Balance Account : "
                    + lowest.getAccountNumber());
        }

        System.out.println("==================================");
    }

}
}
