package mySolution;

import java.util.Map;

public class Main {
    private static final StockList stockList = new StockList();
    private static final Basket myBasket = new Basket("Jorge");

    public static void main(String[] args) {
        populateStockList();
        System.out.println(stockList);

        testReserveItemFunctionality();
    }

    private static void testReserveItemFunctionality() {
        System.out.println("\nTesting items reserve functionality\n");
        addToBasket(myBasket, "Equites", 5);
        System.out.print("Should have 5 reserved and 10 in stock:\n\t");
        getStockAndReservedForItem("Equites");
        System.out.print("Should be able to purchase 5 units, leaving 5 in stock:\n\t");
        purchaseItem(myBasket, "Equites");
        System.out.print("Should have 0 reserved and 5 in stock:\n\t");
        getStockAndReservedForItem("Equites");
        addToBasket(myBasket, "Equites", 5);
        purchaseItem(myBasket, "Equites");
        System.out.print("Should have 0 reserved and 0 in stock:\n\t");
        getStockAndReservedForItem("Equites");
        System.out.print("Should not be able to reserve items due to lack of stock:\n\t");
        addToBasket(myBasket, "Equites", 5);
        System.out.print("Should not be able to purchase due to lack of reserved items:\n\t");
        purchaseItem(myBasket, "Equites");

        Basket secondaryBasket = new Basket("Alternative");
        addToBasket(secondaryBasket, "Archers", 5);
        System.out.print("Should have 5 reserved and 20 in stock:\n\t");
        getStockAndReservedForItem("Archers");
        System.out.print("Should not work due to using the wrong basket:\n\t");
        removeFromBasket(myBasket, "Archers");
        System.out.print("Should remove item from the basket:\n\t");
        removeFromBasket(secondaryBasket, "Archers");


        System.out.print("Should fail when attempting to reserve more items than the available stock:\n\t");
        addToBasket(secondaryBasket, "Generals", 5);
        System.out.print("Should not let you reserve items when another basket has all stock reserved:\n\t");
        addToBasket(secondaryBasket, "Generals", 3);
        seeItemInBasket(secondaryBasket, "Generals");
        System.out.print("\t");
        addToBasket(secondaryBasket, "Generals", 1);

    }

    private static void getStockAndReservedForItem(String name) {
        if (itemIsNull(name)) return;
        stockList.get(name).seeReservedVsStock();
    }

    private static void printPriceList() {
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet())
            System.out.println(price.getKey() + " costs " + price.getValue() + "€");
    }

    private static void operateWithBasket() {
        addToBasket(myBasket, "Equites", 5);
        System.out.println(myBasket);
        addToBasket(myBasket, "Equites", 5);
        System.out.println(myBasket);
        addToBasket(myBasket, "Equites", 5);
        addToBasket(myBasket, "Triarii", 3);
        System.out.println(myBasket);
        addToBasket(myBasket, "Archers", 20);
        addToBasket(myBasket, "Legionaries", 30);
        addToBasket(myBasket, "Auxilia", 1);
        System.out.println(myBasket);
        System.out.println(stockList);
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

    public static int addToBasket(Basket basket, String name, int quantity) {
        if (itemIsNull(name)) return 0;
        StockItem stockItem = stockList.get(name);
        if (stockList.reserveStock(name, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        System.out.println("Unfortunately, there is currently not enough stock of " + name);
        return 0;
    }

    public static int removeFromBasket(Basket basket, String name) {
        if (itemIsNull(name)) return 0;
        StockItem stockItem = stockList.get(name);
        int freedStock = basket.removeFromBasket(stockItem);
        if (freedStock == 0) {
            System.out.println("Could not find " + name + " in this basket");
            return 0;
        }
        stockList.reserveStock(name, -freedStock);
        System.out.println("Removed " + freedStock + " units of " + name + " from your basket");
        return freedStock;
    }

    public static int addItemToList(String name, double price, int quantity) {
        StockItem temp = new StockItem(name, price, quantity);
        return stockList.addStock(temp);
    }

    public static int purchaseItem(Basket basket, String name) {
        if (itemIsNull(name)) return 0;
        return basket.purchaseItemInBasket(stockList.get(name));
    }

    public static int checkItemStock(String name) {
        if (itemIsNull(name)) return 0;
        return stockList.get(name).quantityInStock();
    }

    public static int checkItemReserved(String name) {
        if (itemIsNull(name)) return 0;
        return stockList.get(name).getQuantityReserved();
    }

    public static void seeItemInBasket(Basket basket, String name) {
        if (itemIsNull(name)) System.out.println("Could not find item '" + name + "'");
        else System.out.println(basket.getReservedItemInfo(stockList.get(name)));
    }

    private static boolean itemIsNull(String name) {
        StockItem stockItem = stockList.get(name);
        if (stockItem == null)
            System.out.println(name + " is not available for purchase");
        return stockItem == null;
    }
}
