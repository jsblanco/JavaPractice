public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        populateStockList();
        System.out.println(stockList);

        Basket myBasket = new Basket("Jorge");
        sellItem(myBasket, "Equites", 5);
        System.out.println(myBasket);
        sellItem(myBasket, "Equites", 5);
        System.out.println(myBasket);
        sellItem(myBasket, "Equites", 5);
        sellItem(myBasket, "Triarii", 3);
        System.out.println(myBasket);
        sellItem(myBasket, "Archers", 10);
        sellItem(myBasket, "Legionaries", 30);
        sellItem(myBasket, "Auxilia", 1);
        System.out.println(myBasket);
        System.out.println(stockList);;

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
            System.out.println("This item is not available for purchase");
            return 0;
        }

        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }

    public static int addItemToList(String name, double price, int quantity) {
        StockItem temp = new StockItem(name, price, quantity);
        return stockList.addStock(temp);
    }
}
