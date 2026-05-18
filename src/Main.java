import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {

        Connection conn = DriverManager.getConnection("jdbc:sqlite:inventory.db");
        DatabaseManager.initializeDatabase(conn);

        String choice = "";


        Scanner scanner = new Scanner(System.in);


        try {

            while (!choice.equals("4")) {
                Menu.menu();
                System.out.print("What would you like to do: ");
                choice = scanner.nextLine();
                switch (choice) {
                    case "1" -> {
                        boolean add = true;
                        while (add) {
                            System.out.print("Enter name of item (no commas or special characters): ");
                            String name = scanner.nextLine().toLowerCase();

                            System.out.print("Enter quantity of item: ");
                            String amount = scanner.nextLine();
                            int quantity = Integer.parseInt(amount);

                            System.out.print("Enter price of item: ");
                            String cost = scanner.nextLine();
                            double price = Double.parseDouble(cost);

                            Item newItem = new Item(name, quantity, price);
                            DatabaseManager.addItem(conn, newItem);
                            System.out.print("Would you like to enter another item? (Y/N): ");
                            String again = scanner.nextLine().toUpperCase();
                            if (again.equals("N")) {
                                add = false;

                            }
                        }
                    }
                    case "2" -> {
                        System.out.print("Which item would you like to remove? (enter name in lowercase): ");
                        String itemRemove = scanner.nextLine();
                        DatabaseManager.removeItem(conn, itemRemove);
                    }
                    case "3" -> DatabaseManager.viewItems(conn);

                    case "4" -> {
                        System.out.println("Changes saved. Exiting...");
                        conn.close();
                    }

                }

            }
        } catch (StackOverflowError e) {
        System.out.println("Stack OverFlow");
        } catch (NumberFormatException e) {
        System.out.println("Enter a valid input");
    }
        scanner.close();
    }
}