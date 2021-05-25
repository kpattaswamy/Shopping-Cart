import java.util.HashMap;
import java.util.ArrayList;

public class Inventory {

    //private ArrayList<HashMap<String, ArrayList<Integer>>> itemList = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> itemMap = new HashMap<>();
    private ArrayList<String> nameOfItems = new ArrayList<>();


    public void addItem(String itemName, int quantity, int price){

        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(quantity);
        tempList.add(price);

        itemMap.put(itemName, tempList);
        nameOfItems.add(itemName);

        System.out.println("Updated List: ");
        System.out.println(nameOfItems);
    }

    public ArrayList<Integer> getItem(String itemName){
        ArrayList<Integer> itemValue = itemMap.get(itemName);

        return itemValue;
    }
    //constructor
    public Inventory() {
    }
}
