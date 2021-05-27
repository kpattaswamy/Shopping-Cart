import java.util.HashMap;
import java.util.ArrayList;

public class Inventory {

    private HashMap<String, ArrayList<Double>> itemMap = new HashMap<>();
    private ArrayList<String> nameOfItems = new ArrayList<>();

    public void addItem(String itemName, double quantity, double price){
        if (itemMap.containsKey(itemName)){
            //update existing item
            ArrayList<Double> tempList = new ArrayList<>();

            tempList.add(itemMap.get(itemName).get(0) + quantity);
            tempList.add(itemMap.get(itemName).get(1) + price);

            itemMap.put(itemName, tempList);
        }else{
            //add new item
            ArrayList<Double> tempList = new ArrayList<>();
            tempList.add(quantity);
            tempList.add(price);

            itemMap.put(itemName, tempList);
            nameOfItems.add(itemName);

            printInventory();
        }
    }

    public ArrayList<Double> popItem(String itemName, double quantity){
        if (itemMap.containsKey(itemName) == true){
            ArrayList<Double> temp = new ArrayList<>();

            temp = itemMap.get(itemName);
            double val = temp.get(0) - quantity;

            if (val == 0 || val < 0){
                System.out.println("Item not available anymore!");
                return null;
            }

            temp.set(0, val);
            itemMap.put(itemName, temp);

            temp = itemMap.get(itemName);

            return temp;

        }else{
            System.out.println("Item not available!");

            return null;
        }
    }

    public ArrayList<Double> getItem(String itemName){
        ArrayList<Double> itemValue = itemMap.get(itemName);

        return itemValue;
    }

    public void printInventory(){
        for (String name: itemMap.keySet()) {
            String key = name.toString();
            String value = itemMap.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
    //constructor
    public Inventory() {
    }
}
