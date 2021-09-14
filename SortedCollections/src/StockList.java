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
        if (inStock != item) item.adjustStock(inStock.quantityInStock());
        list.put(item.getName(), item);
        return item.quantityInStock();
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock != null && inStock.quantityInStock() >= quantity && quantity > 0) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String name) {
        return list.get(name);
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
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s += stockItem + ".There are " + stockItem.quantityInStock()
                    + " items in stock, for a total value of " + String.format("%.2f", itemValue) + "€.\n";
            totalValue += itemValue;
        }
        return s + "Total stock value: " + String.format("%.2f", totalValue) + "€.";

    }
}
