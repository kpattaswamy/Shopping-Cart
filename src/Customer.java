import java.util.HashMap;

public class Customer {
    HashMap<String, String> loginCredentials = new HashMap<String, String>();

    public Customer(){
        loginCredentials.put("temp", "password");
    }
}
