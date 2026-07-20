package main;
import exception.AccountNotFoundException;

public class Main {

    public static void main(String[] args) {

        try {

            throw new AccountNotFoundException(
                    "Account not found!");

        }
        catch (AccountNotFoundException e){
            System.out.println(e.getMessage());
        }


        Menu menu = new Menu();
        menu.start();

    }
}
