package hisSolution;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        // Como stockItems extienden de comparador, el treeMap los organiza alfabéticamente de forma automática.
        this.list = new TreeMap<>();
        this.name = name;
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            int newQuantity = inBasket - quantity;
            if (newQuantity > 0)
                list.put(item, newQuantity);
            else if (newQuantity == 0)
                list.remove(item);
            return quantity;
        }
        return 0;
    }

    public void clearBasket(){
        this.list.clear();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size()
                + (list.size() == 1 ? " item" : " items") + ":\n";
        double totalValue = 0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s += item.getKey() + ". " + item.getValue() + " purchased\n";
            totalValue += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total value: " + totalValue + "€";
    }
}
