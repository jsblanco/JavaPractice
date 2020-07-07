import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceries = new ArrayList<String>();

    public GroceryList(ArrayList<String> groceries) {
        this.groceries = groceries;
    }

    public void addGrocery(String item){
        groceries.add(item);
    }

    public void addSpecificGrocery(int index, String item){
        groceries.add(index, item);
    }

    public void printGroceryList(){
        System.out.println("Tienes "+groceries.size()+" elementos en tu lista de la compra:");
        for (int i=0; i<groceries.size(); i++){
            System.out.println(groceries.get(i));
        }
    }

    public void modifyGroceryList(int index, String item){
        groceries.set(index, item);
    }

    public void removeByIndex(int index){
        String item = groceries.get(index);
        groceries.remove(item);
    }

    public void removeItem(String item){
        groceries.remove(item);
    }



}
