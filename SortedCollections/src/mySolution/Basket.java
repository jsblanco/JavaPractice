package mySolution;

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

    public String getReservedItemInfo(StockItem item) {
        int reservedItems = list.getOrDefault(item, 0);
        return item.getName()+": "+reservedItems+" in basket "+name;
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item) {
        if ((item != null)) {
            int inBasket = list.getOrDefault(item, 0);
            list.remove(item);
            return inBasket;
        }
        return 0;
    }

    public int purchaseItemInBasket(StockItem item) {
        if ((item != null)) {
            int inBasket = list.getOrDefault(item, 0);
            if (item.getQuantityReserved() == 0) {
                System.out.println(item.getName() + " has no items reserved");
                return 0;
            }
            item.purchaseReservedStock();
            list.remove(item, inBasket);
            System.out.println("Purchased " + inBasket + " units of " + item.getName() + "; " + item.quantityInStock() + " still in stock.");
            return inBasket;
        }
        return 0;
    }

    public void purchaseAllInBasket() {
        for (Map.Entry<StockItem, Integer> item : list.entrySet())
            purchaseItemInBasket(item.getKey());
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
            s += item.getKey() + ". " + item.getValue() + " reserved\n";
            totalValue += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total value: " + totalValue + "€";
    }
}
