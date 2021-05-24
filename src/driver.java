import java.io.*;
import java.util.*;

public class driver {
    public static void main(String[] args){

        System.out.println("Enter type of user: ");
        Scanner input = new Scanner(System.in);
        String userType = input.nextLine();
        System.out.println(userType);

        if (userType == "Vendor"){
            Admin admin = new Admin();

            System.out.println("Enter Username: ");
            String userName = input.nextLine();
            System.out.println("Enter Password: ");
            String password = input.nextLine();


            boolean flag = true;

            while(flag){
                if (admin.loginCredentials.containsKey(userName)){
                    if (password == admin.loginCredentials.get(userName)){
                        System.out.println("Successfully logged in!");
                        flag = false;
                    }else{
                        System.out.println("Invalid password, re-enter password again! ");
                        password = input.nextLine();

                    }
                }else{
                    System.out.println("Invalid username, re-enter username again! ");

                }

            }




            if (admin.loginCredentials.containsKey(userName)){
                if (password == admin.loginCredentials.get(userName)){
                    System.out.println("Successfully logged in!");
                }else{
                    System.out.println("Invalid password, retry again! ");
                    password = input.nextLine();
                    if(password == admin.loginCredentials.get(userName)){
                        System.out.println("Successfully logged in!");
                    }
                    else{
                        System.out.println("Login faile, exiting program!");
                        System.exit(1);
                    }
                }

            }else{
                System.out.println("Invalid username");
            }



        }else if (userType == "Customer"){
            System.out.println("Inventory empty!");

        }else{
            System.out.println("Unknown user type!");
            System.exit(0);
        }

    }
}
