package hisSolution;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        // Usando LinkedHashMap se mantiene el orden en el que se añaden los elementos.
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item == null) return 0;

        StockItem inStock = list.getOrDefault(item.getName(), item);
        if (inStock != item) item.adjustStock(inStock.getQuantityInStock());
        list.put(item.getName(), item);
        return item.getQuantityInStock();
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && quantity > 0)
            return inStock.reserveStock(quantity);
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if ((inStock != null) && quantity > 0)
            return inStock.unreserveStock(quantity);
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if (inStock != null && (quantity > 0))
            return inStock.finaliseStock(quantity);
        return 0;
    }

    public StockItem get(String name) {
        return list.get(name);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet())
            prices.put(item.getKey(), item.getValue().getPrice());
        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalValue = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantityInStock();
            s += stockItem + ".There are " + stockItem.getQuantityInStock()
                    + " items in stock, for a total value of " + String.format("%.2f", itemValue) + "€.\n";
            totalValue += itemValue;
        }
        return s + "Total stock value: " + String.format("%.2f", totalValue) + "€.";

    }
}
