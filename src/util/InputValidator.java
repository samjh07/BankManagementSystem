package util;

import java.util.Scanner;

public class InputValidator {

    private static final Scanner sc = new Scanner(System.in);

    public static String getName() {

        while (true) {

            System.out.print("Enter Holder Name : ");
            String name = sc.nextLine().trim();

            if (name.matches("[A-Za-z ]{3,40}")) {
                return name;
            }

            System.out.println("Invalid Name.");
        }
    }

    public static String getMobile() {

        while (true) {

            System.out.print("Enter Mobile Number : ");
            String mobile = sc.nextLine().trim();

            if (mobile.matches("[6-9][0-9]{9}")) {
                return mobile;
            }

            System.out.println("Invalid Mobile Number.");
        }
    }

    public static String getEmail() {

        while (true) {

            System.out.print("Enter Email : ");
            String email = sc.nextLine().trim();

            if (email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                return email;
            }

            System.out.println("Invalid Email.");
        }
    }

    public static String getAccountType() {

        while (true) {

            System.out.print("Account Type (Savings/Current): ");

            String type = sc.nextLine().trim();

            if (type.equalsIgnoreCase("Savings") ||
                type.equalsIgnoreCase("Current")) {

                return type;
            }

            System.out.println("Invalid Account Type.");
        }
    }

    public static double getAmount(String message) {

        while (true) {

            System.out.print(message);

            try {

                double amount = Double.parseDouble(sc.nextLine());

                if (amount >= 0) {
                    return amount;
                }

            } catch (Exception e) {

            }

            System.out.println("Invalid Amount.");
        }
    }

    public static String getAccountNumber() {

        while (true) {

            System.out.print("Enter Account Number : ");

            String account = sc.nextLine().trim();

            if (account.matches("ACC\\d{4,}")) {
                return account;
            }

            System.out.println("Invalid Account Number.");
        }
    }
}
