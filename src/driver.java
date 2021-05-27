import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class driver {
    public static void main(String[] args){

        System.out.println("Enter type of user: ");
        Scanner input = new Scanner(System.in);
        String userType = input.nextLine();

        if (userType.equals("Vendor")){

            Admin admin = new Admin();

            System.out.println("Enter Username: ");
            String userName = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            boolean flag = true;

            //logging in for vendor
            while(flag){
                if (admin.loginCredentials.containsKey(userName)){
                    if (password.equals(admin.loginCredentials.get(userName))){
                        System.out.println("Successfully logged in!");
                        flag = false;
                    }else{
                        System.out.println("Invalid password, re-enter password again or press x to exit ");
                        String temp = input.nextLine();

                        if (!temp.equals("x")){
                            password = temp;
                        }else{
                            System.out.println("Exiting program");
                            System.exit(0);
                        }
                    }
                }else{
                    System.out.println("Invalid username, re-enter username again or press x to exit ");
                    String temp = input.nextLine();

                    if (!temp.equals("x")){
                        userName = temp;
                    }else{
                        System.out.println("Exiting program");
                        System.exit(0);
                    }
                }
            }

            Inventory inventory = new Inventory();
            flag = true;
            //add stuff to the inventory
            while(flag){
                double quantity = 0;
                double price = 0;
                String itemName = "";

                System.out.println("Enter item, quantity, price OR 'x' to exit adding items");
                itemName = input.nextLine();


                if (itemName.equals("x")){
                    flag = false;
                    break;
                }

                try{
                    quantity = Integer.parseInt(input.nextLine());
                }catch(InputMismatchException e){
                    System.out.println("Not a number!");
                }

                try{
                    price = Double.parseDouble(input.nextLine());
                }catch(InputMismatchException e){
                    System.out.println("Not a number!");
                }

                inventory.addItem(itemName, quantity, price);
            }

            System.out.println("Current inventory: ");
            inventory.printInventory();

            Customer customer = new Customer();

            //logging in for customer
            System.out.println("Enter Username for Customer: ");
            userName = input.nextLine();
            System.out.println("Enter Password for Customer: ");
            password = input.nextLine();
            flag = true;

            while(flag){
                if (customer.loginCredentials.containsKey(userName)){
                    if (password.equals(customer.loginCredentials.get(userName))){
                        System.out.println("Successfully logged in!");
                        flag = false;
                    }else{
                        System.out.println("Invalid password, re-enter password again or press x to exit ");
                        String temp = input.nextLine();

                        if (!temp.equals("x")){
                            password = temp;
                        }else{
                            System.out.println("Exiting program");
                            System.exit(0);
                        }
                    }
                }else{
                    System.out.println("Invalid username, re-enter username again or press x to exit ");
                    String temp = input.nextLine();

                    if (!temp.equals("x")){
                        userName = temp;
                    }else{
                        System.out.println("Exiting program");
                        System.exit(0);
                    }
                }
            }
            flag = true;

            ArrayList<ArrayList<Double>> receiptList = new ArrayList<>();
            ArrayList<String> receiptNames = new ArrayList<>();

            //customer buying
            while(flag){


                System.out.println("Enter name of item to purchase or press 'x' when finished");
                String toBuy = input.nextLine();

                if (toBuy.equals("x")){
                    flag = false;
                    break;
                }

                System.out.println("Enter quantity of item to purchase");
                double quantity = Integer.parseInt(input.nextLine());

                ArrayList<Double> itemBought = new ArrayList<>(inventory.popItem(toBuy, quantity));


                itemBought.set(0, quantity);

                receiptList.add(itemBought);
                receiptNames.add(toBuy);

                System.out.println("Available Inventory: ");
                inventory.printInventory();
            }

            System.out.println("Updated Inventory: ");
            inventory.printInventory();

            //print receipt

            System.out.println("Receipt: ");
            for (int i = 0; i < receiptNames.size(); i++){
                System.out.println(receiptNames.get(i));
                System.out.println(receiptList.get(i));
            }

            System.out.println("Thanks for shopping ");

        }else if (userType.equals("Customer")){
            System.out.println("Inventory empty!");

        }else{
            System.out.println("Unknown user type!");
            System.exit(0);
        }

    }
}
