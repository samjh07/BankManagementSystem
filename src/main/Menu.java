package main;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    public void start() {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("   BANK MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Search Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Delete Account");
            System.out.println("7. Check Balance");
            System.out.println("8. Transfer Money");
            System.out.println("9. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Create Account selected.");
                    break;

                case 2:
                    System.out.println("Deposit selected.");
                    break;

                case 3:
                    System.out.println("Withdraw selected.");
                    break;

                case 4:
                    System.out.println("Search selected.");
                    break;

                case 5:
                    System.out.println("Display All selected.");
                    break;

                case 6:
                    System.out.println("Delete selected.");
                    break;

                case 7:
                    System.out.println("Check Balance selected.");
                    break;

                case 8:
                    System.out.println("Transfer selected.");
                    break;

                case 9:
                    System.out.println("\nThank you for using Bank Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
