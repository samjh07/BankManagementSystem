package model;

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
}
