package mySolution;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;
    private int reserved = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price > 0.0 ? price : 0;
        this.quantityStock = quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) this.price = price;
    }

    public boolean canReserveQuantity(int quantity) {
        return ((this.reserved + quantity) <= quantityStock);
    }

    public int reserveStock(int quantity) {
        if (!canReserveQuantity(quantity)) return 0;
        this.reserved += quantity;
        return this.reserved;
    }

    public int purchaseReservedStock() {
        this.quantityStock -= this.reserved;
        this.reserved = 0;
        return this.quantityStock;
    }

    public void adjustStock(int quantityStock) {
        int newQuantity = this.quantityStock + quantityStock;
        if (newQuantity >= 0) this.quantityStock = newQuantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityReserved() {
        return reserved;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void seeReservedVsStock() {
        System.out.println(name+": "+reserved+" items reserved vs "+quantityStock+" in stock");
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) return true;

        if ((obj == null) || (obj.getClass() != this.getClass())) return false;

        return this.name.equals(((StockItem) obj).getName());
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        if (o == this) return 0;
        if (o != null) return this.name.compareTo(o.getName());
        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price + "€";
    }
}
