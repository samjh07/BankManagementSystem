package util;

public class ConsoleUtil {

    public static void printTitle(String title) {

        System.out.println();
        System.out.println("======================================");
        System.out.println(title);
        System.out.println("======================================");
    }

    public static void printLine() {

        System.out.println("--------------------------------------");
    }

    public static void success(String message) {

        System.out.println("[SUCCESS] " + message);
    }

    public static void error(String message) {

        System.out.println("[ERROR] " + message);
    }

    public static void info(String message) {

        System.out.println("[INFO] " + message);
    }

    public static void exitMessage() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("Thank you for using Bank Management System.");
        System.out.println("======================================");
    }
}
