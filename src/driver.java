import java.io.*;
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



        }else if (userType.equals("Customer")){
            System.out.println("Inventory empty!");

        }else{
            System.out.println("Unknown user type!");
            System.exit(0);
        }

    }
}
