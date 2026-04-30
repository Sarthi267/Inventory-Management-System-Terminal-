import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
         ArrayList<Item> list = new ArrayList<>();

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
                        while(add) {
                            System.out.print("Enter name of item: ");
                            String name = scanner.nextLine().toLowerCase();

                            System.out.print("Enter quantity of item: ");
                            String amount = scanner.nextLine();
                            int quantity = Integer.parseInt(amount);

                            System.out.print("Enter price of item: ");
                            String cost = scanner.nextLine();
                            double price = Double.parseDouble(cost);

                            Item newItem = new Item(name, quantity, price);
                            list.add(newItem);
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
                        boolean removed = list.removeIf(i -> i.name.equalsIgnoreCase(itemRemove));
                        if(removed){
                            System.out.println("item removed successfully");
                            Thread.sleep(2000);
                        } else{
                            System.out.println("item not found in inventory");
                        }
                    }
                    case "3" -> {
                        System.out.println("********** Current Inventory **********");
                        if(list.isEmpty()){
                            System.out.println("Inventory is empty");
                            Thread.sleep(2000);

                        } else {
                            for (Item i : list) {
                                System.out.printf("Item: %s | Quantity: %d | Price: $%.2f\n",  i.name ,  i.quantity, i.price);
                            }
                            Thread.sleep(2000);
                        }
                    }
                    case "4" -> System.out.println("You have exited the program");


                }


            }
        } catch(StackOverflowError e){
            System.out.println("Stack OverFlow");
        } catch(InterruptedException e){
            System.out.println("Thread was interrupted");
        } catch(NumberFormatException e){
            System.out.println("Enter a valid input");
        }



        scanner.close();
        }


    }

