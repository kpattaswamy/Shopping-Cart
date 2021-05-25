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
