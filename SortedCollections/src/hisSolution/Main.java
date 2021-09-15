package hisSolution;

import java.util.Map;

public class Main {
    private static final StockList stockList = new StockList();
    private static final Basket myBasket = new Basket("Jorge");

    public static void main(String[] args) {
        populateStockList();
        operateWithBasket();


    }

    private static void printPriceList() {
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet())
            System.out.println(price.getKey() + " costs " + price.getValue() + "€");
    }

    private static void operateWithBasket() {
        sellItem(myBasket, "Equites", 5);
        System.out.println(myBasket);
        sellItem(myBasket, "Equites", 5);
        System.out.println(myBasket);
        sellItem(myBasket, "Equites", 5);
        sellItem(myBasket, "Triarii", 3);
        sellItem(myBasket, "Archers", 10);
        sellItem(myBasket, "Legionaries", 30);
        sellItem(myBasket, "Auxilia", 1);

        Basket basket = new Basket("Customer");
        sellItem(basket, "Legionary", 20);
        sellItem(basket, "Auxilia", 5);
        removeItem(basket, "Auxilia", 5);
        System.out.println(basket);

        removeItem(myBasket, "Legionaries", 20);
        removeItem(myBasket, "Equites", 10);
        System.out.println("Equites removed: " + removeItem(myBasket, "Equites", 10));

        System.out.println(myBasket);
        removeItem(myBasket, "Auxilia", 2);
        checkout(myBasket);
        System.out.println(myBasket);
        System.out.println(stockList);

        basket.clearBasket();
        checkout(basket);
        System.out.println(basket);
    }

    private static void testUnmodifiableMap() {
//      Funcionará porque, aunque no podamos modificar esta colección, podemos modificar sus ítems
        stockList.Items().get("Equites").setPrice(35.49);
        stockList.get("Equites").setPrice(32.49);
        System.out.println(stockList.Items().get("Equites"));
//      Fallará porque no podemos cambiar la colección
        StockItem temp = new StockItem("Sarmatian", 98, 5);
        stockList.Items().put(temp.getName(), temp);
    }

    private static void populateStockList() {
        addItemToList("Legionaries", 24.99, 100);
        addItemToList("Equites", 26.99, 10);
        addItemToList("Auxilia", 25.99, 30);
        addItemToList("Archers", 20.99, 20);
        addItemToList("Generals", 29.99, 3);
        addItemToList("War Elephants", 32.99, 15);
        addItemToList("Balearic slingers", 26.49, 5);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " is not available for purchase");
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0)
            return basket.addToBasket(stockItem, quantity);
        System.out.println("Unfortunately, there is currently no more stock of " + item);
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " is not available for purchase");
            return 0;
        }
        if (basket.removeFromBasket(stockItem, quantity) == quantity)
            return stockList.unreserveStock(item, quantity);
        System.out.println("Unfortunately, there is currently no more stock of " + item);
        return 0;
    }

    public static void checkout(Basket basket) {
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet())
            stockList.sellStock(item.getKey().getName(), item.getValue());
        basket.clearBasket();
    }

    public static int addItemToList(String name, double price, int quantity) {
        StockItem temp = new StockItem(name, price, quantity);
        return stockList.addStock(temp);
    }
}
